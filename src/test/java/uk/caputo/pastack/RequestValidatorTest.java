package uk.caputo.pastack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestValidatorTest {

  @Autowired RequestValidator requestValidator;

  @Test
  void validate_ValidQuery_ShouldReturnTrue() {
    assertThat(requestValidator.validate("what is reflection?")).isTrue();
    assertThat(requestValidator.validate("what is @Autowired?")).isTrue();
    assertThat(requestValidator.validate("resttemplate vs webclient")).isTrue();
  }

  @Test
  void validate_IllegalQuery_ShouldThrowIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          requestValidator.validate("");
          requestValidator.validate("123");
          requestValidator.validate("./*");
          requestValidator.validate("q");
        });
  }
}
