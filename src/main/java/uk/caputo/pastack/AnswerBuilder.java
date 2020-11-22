package uk.caputo.pastack;

import java.net.URL;
import java.util.Date;
import org.springframework.stereotype.Component;

/** A class that acts as the builder for Answer objects. */
@Component
public class AnswerBuilder {
  private int upvotes;
  private String question;
  private boolean isBestAnswer;
  private URL url;
  private Date date;
  private String author;
  private String content;

  public AnswerBuilder setUpvotes(int upvotes) {
    this.upvotes = upvotes;
    return this;
  }

  public AnswerBuilder setBestAnswer(boolean bestAnswer) {
    isBestAnswer = bestAnswer;
    return this;
  }

  public AnswerBuilder setUrl(URL url) {
    this.url = url;
    return this;
  }

  public AnswerBuilder setDate(Date date) {
    this.date = date;
    return this;
  }

  public AnswerBuilder setAuthor(String author) {
    this.author = author;
    return this;
  }

  public AnswerBuilder setContent(String content) {
    this.content = content;
    return this;
  }

  public AnswerBuilder setQuestion(String question) {
    this.question = question;
    return this;
  }

  /**
   * Instantiates and returns a new instance of Answer.
   *
   * @return an immutable instance of Answer.
   */
  public Answer build() {
    return new Answer(upvotes, question, isBestAnswer, url, date, author, content);
  }
}
