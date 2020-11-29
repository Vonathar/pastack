package uk.caputo.pastack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;

/**
 * A class that represents a JSON response from the StackExchange API. The "items" key is the
 * top-level wrapper for individual objects, and remains the same for any query type.
 */
@JsonRootName("items")
public class StackExchangeResponse<T> {

  @JsonProperty("items")
  private List<T> items;

  @JsonProperty("items")
  public List<T> getItems() {
    return items;
  }
}
