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
    Question mockQuestion =
        new Question("Title", 5, new Date(), new URL("https://www.stackoverflow.com"), 5);

    Answer answer =
        answerBuilder
            .setUpvotes(100)
            .setQuestion(mockQuestion)
            .setBestAnswer(true)
            .setUrl(mockUrl)
            .setDate(mockDate)
            .setAuthor("Jon Doe")
            .setContent("Lorem ipsum.")
            .build();

    assertThat(answer.isBestAnswer()).isTrue();
    assertThat(answer.getQuestion()).isNotNull();
    assertThat(answer.getUpvotes()).isEqualTo(100);
    assertThat(answer.getUrl()).isEqualTo(mockUrl);
    assertThat(answer.getDate()).isEqualTo(mockDate);
    assertThat(answer.getAuthor()).isEqualTo("Jon Doe");
    assertThat(answer.getContent()).isEqualTo("Lorem ipsum.");
  }
}
