package uk.caputo.pastack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A class that represents a single question on the StackOverflow website. This class is used by
 * Jackson to deserialize responses from the StackExchange API.
 */
@JsonPropertyOrder({"is_answered", "score", "creation_date", "question_id", "link", "title"})
public class Question {

  @JsonProperty("is_answered")
  private boolean isAnswered;

  @JsonProperty("score")
  private Integer score;

  @JsonProperty("creation_date")
  private Integer date;

  @JsonProperty("question_id")
  private Integer id;

  @JsonProperty("link")
  private String url;

  @JsonProperty("title")
  private String title;

  @JsonProperty("is_answered")
  public boolean isAnswered() {
    return isAnswered;
  }

  @JsonProperty("score")
  public Integer getScore() {
    return score;
  }

  @JsonProperty("creation_date")
  public Integer getDate() {
    return date;
  }

  @JsonProperty("question_id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("link")
  public String getUrl() {
    return url;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
}
