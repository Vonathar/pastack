package uk.caputo.pastack;

import org.springframework.stereotype.Component;

/** A class that is responsible to validate queries for the StackExchange API. */
@Component
public class RequestValidator {

  /**
   * Checks if a String is a valid query for the StackExchange API.
   *
   * @param query the string to validate.
   * @return whether the string is a valid query.
   * @throws IllegalArgumentException if the string is not a valid query.
   */
  public boolean validate(String query) {
    if (query.length() < 3) {
      throw new IllegalArgumentException("Query must be at least 3 characters long.");
    } else if (query.matches("^\\W+$")) {
      throw new IllegalArgumentException("Query cannot contain only non-word characters.");
    } else if (query.matches("^\\d+$")) {
      throw new IllegalArgumentException("Query cannot contain only numbers.");
    } else {
      return true;
    }
  }
}
