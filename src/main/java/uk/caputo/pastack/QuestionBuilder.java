package uk.caputo.pastack;

import java.net.URL;
import java.util.Date;
import org.springframework.stereotype.Component;

/** A class that acts as the builder for Question objects. */
@Component
public class QuestionBuilder {
  private String title;
  private int id;
  private Date date;
  private URL url;
  private int score;

  public QuestionBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public QuestionBuilder setId(int id) {
    this.id = id;
    return this;
  }

  public QuestionBuilder setDate(Date date) {
    this.date = date;
    return this;
  }

  public QuestionBuilder setUrl(URL url) {
    this.url = url;
    return this;
  }

  public QuestionBuilder setScore(int score) {
    this.score = score;
    return this;
  }
  /**
   * Instantiates and returns a new instance of Question.
   *
   * @return an immutable instance of Question.
   */
  public Question build() {
    return new Question(title, id, date, url, score);
  }
}
