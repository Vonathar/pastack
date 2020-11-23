package uk.caputo.pastack;

import java.net.URL;
import java.util.Date;

/**
 * A class that represents a single answer to a question on the StackOverflow website. It is not
 * managed by Spring, and relies on AnswerBuilder for instantiation. The only exposed methods are
 * getters, in order to preserve immutability.
 */
public class Answer {

  private final Question question;
  private final int upvotes;
  private final boolean isBestAnswer;
  private final URL url;
  private final Date date;
  private final String author;
  private final String content;

  public Answer(
      Question question,
      int upvotes,
      boolean isBestAnswer,
      URL url,
      Date date,
      String author,
      String content) {
    this.upvotes = upvotes;
    this.question = question;
    this.isBestAnswer = isBestAnswer;
    this.url = url;
    this.date = date;
    this.author = author;
    this.content = content;
  }

  public int getUpvotes() {
    return upvotes;
  }

  public boolean isBestAnswer() {
    return isBestAnswer;
  }

  public URL getUrl() {
    return url;
  }

  public Date getDate() {
    return date;
  }

  public String getAuthor() {
    return author;
  }

  public Question getQuestion() {
    return question;
  }

  public String getContent() {
    return content;
  }
}
