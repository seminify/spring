package org.seminify.application.file

import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import org.springframework.web.multipart.MultipartFile
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service
class FileService(fileProperties: FileProperties) {
    private val path: Path

    init {
        if (fileProperties.path.trim().isEmpty())
            throw RuntimeException("File upload location can not be Empty.")
        path = Paths.get(fileProperties.path)
    }

    fun paths(): List<Path> {
        return Files.walk(path, 1).filter { it != path }.map { it.relativize(path) }.toList()
    }

    fun resource(filename: String): Resource {
        val resource = UrlResource(this.path.resolve(filename).toUri())
        if (resource.exists() || resource.isReadable)
            return resource
        else throw FileNotFoundException("Could not read file: $filename")
    }

    fun store(multipartFile: MultipartFile) {
        if (multipartFile.isEmpty)
            throw RuntimeException("Failed to store empty file.")
        val path = this.path.resolve(
            multipartFile.originalFilename ?: throw RuntimeException("Failed to store file with null filename")
        ).normalize().toAbsolutePath()
        if (!path.parent.equals(this.path.toAbsolutePath()))
            throw RuntimeException("Cannot store file outside current directory.")
        multipartFile.inputStream.use {
            Files.copy(it, path, StandardCopyOption.REPLACE_EXISTING)
        }
    }

    fun deleteAll() {
        FileSystemUtils.deleteRecursively(path.toFile())
    }

    fun init() {
        Files.createDirectories(path)
    }
}
