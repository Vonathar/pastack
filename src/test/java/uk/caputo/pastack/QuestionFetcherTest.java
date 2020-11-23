package uk.caputo.pastack;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionFetcherTest {

  @Autowired QuestionFetcher questionFetcher;

  @Test
  public void fetch_ValidQuery_ShouldReturnMinOneMaxFiveQuestions() throws MalformedURLException {
    ArrayList<Question> questions = questionFetcher.fetch("What is a Stack Overflow?");
    assertThat(questions).hasSizeBetween(1, 5);
  }
}
