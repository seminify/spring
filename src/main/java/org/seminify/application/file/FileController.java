package org.seminify.application.file;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

  private final FileService fileService;

  public FileController(FileService fileService) {
    this.fileService = fileService;
  }

  @GetMapping
  public String string(Model model) {
    model.addAttribute(
      "files",
      fileService
        .paths()
        .stream()
        .map(arg0 ->
          MvcUriComponentsBuilder.fromMethodName(
            FileController.class,
            "responseEntity",
            arg0.getFileName().toString()
          )
            .build()
            .toUriString()
        )
        .toList()
    );
    System.out.println(model.asMap());
    return "fileForm";
  }

  @GetMapping("{filename}")
  @ResponseBody
  public ResponseEntity<Resource> responseEntity(
    @PathVariable String filename
  ) {
    var resource = fileService.resource(filename);
    if (resource == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok()
      .header(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + resource.getFilename() + "\""
      )
      .body(resource);
  }

  @PostMapping
  public String string(
    @RequestParam("file") MultipartFile multipartFile,
    RedirectAttributes redirectAttributes
  ) {
    fileService.store(multipartFile);
    redirectAttributes.addFlashAttribute(
      "message",
      "You successfully uploaded " + multipartFile.getOriginalFilename() + "!"
    );
    return "redirect:/";
  }

  @ExceptionHandler(FileNotFoundException.class)
  public ResponseEntity<?> fileNotFoundExceptionHandler(
    FileNotFoundException a
  ) {
    return ResponseEntity.notFound().build();
  }
}
