package uk.caputo.pastack;

import java.net.URL;
import java.util.Date;

/**
 * A class that represents a single question on the StackOverflow website. It is not managed by
 * Spring, and relies on QuestionBuilder for instantiation. The only exposed methods are getters, in
 * order to preserve immutability.
 */
public class Question {
  private final String title;
  private final int id;
  private final Date date;
  private final URL url;
  private final int score;

  public Question(String title, int id, Date date, URL url, int score) {
    this.title = title;
    this.id = id;
    this.date = date;
    this.url = url;
    this.score = score;
  }

  public String getTitle() {
    return title;
  }

  public int getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public URL getUrl() {
    return url;
  }

  public int getScore() {
    return score;
  }
}
