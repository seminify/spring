package org.seminify.application.file

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.nio.file.Paths

@SpringBootTest
@AutoConfigureMockMvc
class FileServiceTest(@Autowired private val mockmvc: MockMvc) {
    @MockitoBean
    private lateinit var fileService: FileService

    @Test
    fun shouldListAllFiles() {
        given(fileService.paths())
            .willReturn(listOf(Paths.get("first.txt"), Paths.get("second.txt")))
        mockmvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(
                model().attribute(
                    "files",
                    Matchers.contains(
                        "http://localhost/first.txt",
                        "http://localhost/second.txt"
                    )
                )
            )
    }

    @Test
    fun shouldSaveUploadedFile() {
        val multipartFile = MockMultipartFile(
            "file",
            "test.txt",
            "text/plain",
            "Spring Framework".toByteArray()
        )
        mockmvc.perform(multipart("/").file(multipartFile))
            .andExpect(status().isFound)
            .andExpect(header().string("Location", "/"))

        then(fileService).should().store(multipartFile)
    }

    @Test
    fun should404WhenMissingFile() {
        given(fileService.resource("test.txt"))
            .willThrow(FileNotFoundException::class.java)
        mockmvc.perform(get("/files/test.txt"))
            .andExpect(status().isNotFound)
    }
}
