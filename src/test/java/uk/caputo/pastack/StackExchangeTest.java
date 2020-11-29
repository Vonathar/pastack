package uk.caputo.pastack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StackExchangeTest {

  @Autowired private StackExchange stackExchange;

  @Test
  void fetchQuestions_ValidQuery_ShouldReturnOneOrMoreQuestions() {
    QuestionList questions = stackExchange.fetchQuestions("What is reflection");
    assertThat(questions.getQuestions()).hasSizeGreaterThan(1);
  }

  @Test
  void fetchQuestions_IllegalQuery_ShouldThrowIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          stackExchange.fetchQuestions("");
          stackExchange.fetchQuestions("123");
          stackExchange.fetchQuestions("./*");
          stackExchange.fetchQuestions("q");
        });
  }

  @Test
  void fetchAnswers_ValidQuestionId_ShouldReturnOneOrMoreAnswers() {
    AnswerList answers = stackExchange.fetchAnswers("11227809");
    assertThat(answers.getAnswers()).hasSizeGreaterThan(1);
  }

  @Test
  void fetchAnswers_IllegalQuestionId_ShouldThrowIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          stackExchange.fetchAnswers("NaN");
          stackExchange.fetchAnswers("0");
          stackExchange.fetchAnswers("x123456");
          stackExchange.fetchAnswers("123y456");
          stackExchange.fetchAnswers("123456z");
        });
  }
}
