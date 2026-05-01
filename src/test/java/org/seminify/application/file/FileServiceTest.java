package org.seminify.application.file;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Paths;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FileServiceTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private FileService fileService;

  @Test
  public void shouldListAllFiles() throws Exception {
    given(this.fileService.paths()).willReturn(
      List.of(Paths.get("first.txt"), Paths.get("second.txt"))
    );
    this.mockMvc.perform(get("/"))
      .andExpect(status().isOk())
      .andExpect(
        model().attribute(
          "files",
          Matchers.contains(
            "http://localhost/first.txt",
            "http://localhost/second.txt"
          )
        )
      );
  }

  @Test
  public void shouldSaveUploadedFile() throws Exception {
    MockMultipartFile multipartFile = new MockMultipartFile(
      "file",
      "test.txt",
      "text/plain",
      "Spring Framework".getBytes()
    );
    mockMvc
      .perform(multipart("/").file(multipartFile))
      .andExpect(status().isFound())
      .andExpect(header().string("Location", "/"));

    then(fileService).should().store(multipartFile);
  }

  @Test
  public void should404WhenMissingFile() throws Exception {
    given(fileService.resource("test.txt")).willThrow(
      FileNotFoundException.class
    );
    mockMvc.perform(get("/files/test.txt")).andExpect(status().isNotFound());
  }
}
