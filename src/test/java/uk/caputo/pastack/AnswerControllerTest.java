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
  public void getAnswers_QuestionSpecified_ShouldReturnAnswersJson() throws Exception {
    this.mvc
        .perform(get("/answers?question=test+question"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void getAnswers_QuestionNotSpecified_ShouldReturnHttpStatusCode400() throws Exception {
    this.mvc.perform(get("/answers")).andExpect(status().isBadRequest());
  }
}
