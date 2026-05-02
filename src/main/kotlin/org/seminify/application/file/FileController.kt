package org.seminify.application.file

import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class FileController(private val fileService: FileService) {
    @GetMapping
    fun string(model: Model): String {
        model.addAttribute(
            "files",
            fileService.paths().stream().map {
                MvcUriComponentsBuilder.fromMethodName(
                    FileController::class.java,
                    "responseEntity",
                    it.fileName.toString()
                ).build().toUri().toString()
            }.toList()
        )
        return "fileForm"
    }

    @GetMapping("{filename}")
    @ResponseBody
    fun responseEntity(@PathVariable filename: String): ResponseEntity<Resource> {
        val resource = fileService.resource(filename) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"${resource.filename}\"").body(resource)

    }

    @PostMapping
    fun string(@RequestParam("file") multipartFile: MultipartFile, redirectAttributes: RedirectAttributes): String {
        fileService.store(multipartFile)
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded ${multipartFile.originalFilename}!")
        return "redirect:/"
    }

    @ExceptionHandler(FileNotFoundException::class)
    fun fileNotFoundExceptionHandler(fileNotFoundException: FileNotFoundException): ResponseEntity<*> {
        return ResponseEntity.notFound().build<Any>()
    }
}
