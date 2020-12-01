package uk.caputo.pastack;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/** A class that is responsible to send requests to the StackExchange API. */
@Component
public class StackExchange {

  private final WebClient client = WebClient.create();

  /**
   * Sends a GET request to the API to fetch all questions found for a given query.
   *
   * @param query the questions to search on StackOverflow.
   * @return the deserialized Question objects from the response.
   */
  public StackExchangeResponse<Question> fetchQuestions(String query) {
    String URL_PATH = "https://api.stackexchange.com/2.2/search/advanced";
    String parameters =
        "?order=desc"
            + "&sort=relevance"
            + "&site=stackoverflow"
            + "&filter=!)rbHx(F9SBjMpzL73Z9u"
            + "&q="
            + URLEncoder.encode(query, StandardCharsets.UTF_8);
    String url = URL_PATH + parameters;
    ParameterizedTypeReference<StackExchangeResponse<Question>> responseType =
        new ParameterizedTypeReference<>() {};
    return client.get().uri(url).retrieve().bodyToMono(responseType).block();
  }

  /**
   * Sends a GET request to the API to fetch all answers found for a given question ID.
   *
   * @param questionId the ID of the question.
   * @return the deserialized Answer objects from the response.
   */
  public StackExchangeResponse<Answer> fetchAnswers(String questionId) {
    String URL_PATH = "https://api.stackexchange.com/2.2/questions/" + questionId + "/answers";
    String parameters =
        "?order=desc"
            + "&sort=votes"
            + "&site=stackoverflow"
            + "&answers=1"
            + "&filter=!41H6nCj-BdupkxH)i";
    String url = URL_PATH + parameters;
    ParameterizedTypeReference<StackExchangeResponse<Answer>> responseType =
        new ParameterizedTypeReference<>() {};
    return client.get().uri(url).retrieve().bodyToMono(responseType).block();
  }
}
