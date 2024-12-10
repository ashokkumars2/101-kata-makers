package kata.makers;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void getUserNameReturnsCorrectName()  {
    String response = this.restTemplate.getForObject("/username", String.class);
    assertEquals("User", response);
  }
}