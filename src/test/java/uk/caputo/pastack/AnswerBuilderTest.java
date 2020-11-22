package uk.caputo.pastack;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/** A class used to test the AnswerBuilder by building an Answer object. */
@SpringBootTest
class AnswerBuilderTest {

  @Autowired AnswerBuilder answerBuilder;

  @Test
  public void build_BuilderFieldsPopulated_ShouldBuildValidAnswerObject()
      throws MalformedURLException {
    URL mockUrl = new URL("https://www.stackoverflow.com");
    Date mockDate = new Date();
    Answer answer =
        answerBuilder
            .setUpvotes(100)
            .setBestAnswer(true)
            .setUrl(mockUrl)
            .setDate(mockDate)
            .setAuthor("Jon Doe")
            .setContent("Lorem ipsum.")
            .build();

    assertThat(answer.isBestAnswer()).isTrue();
    assertThat(answer.getUpvotes()).isEqualTo(100);
    assertThat(answer.getUrl()).isEqualTo(mockUrl);
    assertThat(answer.getDate()).isEqualTo(mockDate);
    assertThat(answer.getAuthor()).isEqualTo("Jon Doe");
    assertThat(answer.getContent()).isEqualTo("Lorem ipsum.");
  }
}
