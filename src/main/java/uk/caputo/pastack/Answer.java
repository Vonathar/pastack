package uk.caputo.pastack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;

/**
 * A class that represents a single answer to a question on the StackOverflow website. This class is
 * used by Jackson to deserialize responses from the StackExchange API.
 */
@JsonPropertyOrder({"is_accepted", "score", "creation_date", "body"})
public class Answer {

  @JsonProperty("is_accepted")
  private boolean isAccepted;

  @JsonProperty("score")
  private int score;

  @JsonProperty("creation_date")
  private Date date;

  @JsonProperty("body")
  private String body;

  @JsonProperty("is_accepted")
  public boolean isAccepted() {
    return isAccepted;
  }

  @JsonProperty("score")
  public int getScore() {
    return score;
  }

  @JsonProperty("creation_date")
  public Date getDate() {
    return date;
  }

  @JsonProperty("body")
  public String getBody() {
    return body;
  }
}
