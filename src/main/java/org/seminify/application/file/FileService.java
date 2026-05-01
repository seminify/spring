package org.seminify.application.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  private final Path path;

  public FileService(FileProperties fileProperties) {
    if (
      fileProperties.getPath().trim().length() == 0
    ) throw new RuntimeException("File upload location can not be Empty.");
    this.path = Paths.get(fileProperties.getPath());
  }

  public List<Path> paths() {
    try {
      return Files.walk(path, 1)
        .filter(arg0 -> !arg0.equals(path))
        .map(path::relativize)
        .toList();
    } catch (IOException e) {
      throw new RuntimeException("Failed to read stored files", e);
    }
  }

  public Resource resource(String filename) {
    try {
      var resource = new UrlResource(path.resolve(filename).toUri());
      if (resource.exists() || resource.isReadable()) return resource;
      throw new FileNotFoundException("Could not read file: " + filename);
    } catch (MalformedURLException e) {
      throw new FileNotFoundException("Could not read file: " + filename, e);
    }
  }

  public void store(MultipartFile multipartFile) {
    if (multipartFile.isEmpty()) throw new RuntimeException(
      "Failed to store empty file."
    );
    var path = this.path.resolve(Paths.get(multipartFile.getOriginalFilename()))
      .normalize()
      .toAbsolutePath();
    if (
      !path.getParent().equals(this.path.toAbsolutePath())
    ) throw new RuntimeException(
      "Cannot store file outside current directory."
    );
    try (var inputStream = multipartFile.getInputStream()) {
      Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException("Failed to store file.", e);
    }
  }

  public void deleteAll() {
    FileSystemUtils.deleteRecursively(path.toFile());
  }

  public void init() {
    try {
      Files.createDirectories(path);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize storage", e);
    }
  }
}
