package uk.caputo.pastack;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * A class used to test the AnswerController by sending mock requests to the '/answers' endpoint.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AnswerControllerTest {

  @Autowired private MockMvc mvc;

  @Test
  public void getAnswers_ValidQuestion_ShouldReturnAnswersJson() throws Exception {
    this.mvc
        .perform(get("/answers?query=what+is+reflection"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void getAnswers_IllegalQuestion_ShouldReturnHttpStatusCode400() throws Exception {
    this.mvc.perform(get("/answers?query=")).andExpect(status().isBadRequest());
    this.mvc.perform(get("/answers?query=123")).andExpect(status().isBadRequest());
    this.mvc.perform(get("/answers?query=./*")).andExpect(status().isBadRequest());
    this.mvc.perform(get("/answers?query=q")).andExpect(status().isBadRequest());
  }
}
