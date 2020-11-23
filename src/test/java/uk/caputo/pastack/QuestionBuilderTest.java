package uk.caputo.pastack;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionBuilderTest {

  @Autowired QuestionBuilder questionBuilder;

  @Test
  public void build_BuilderFieldsPopulated_ShouldBuildValidQuestionObject()
      throws MalformedURLException {
    URL mockUrl = new URL("https://www.stackoverflow.com");
    Date mockDate = new Date();

    Question question =
        questionBuilder
            .setId(1)
            .setScore(10)
            .setTitle("Title")
            .setDate(mockDate)
            .setUrl(mockUrl)
            .build();

    assertThat(question.getId()).isNotZero();
    assertThat(question.getScore()).isNotNull();
    assertThat(question.getTitle()).isNotNull();
    assertThat(question.getDate()).isNotNull();
    assertThat(question.getUrl()).isNotNull();
  }
}
