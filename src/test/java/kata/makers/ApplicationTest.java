package kata.makers;


import static org.junit.jupiter.api.Assertions.assertEquals;

import kata.makers.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTest {

  @Autowired
  UserService userService;

  @LocalServerPort
  private int port;

  @Test
  void getUserNameReturnsCorrectName()  {
    System.out.println("Port: " + port);

    String response = userService.getUserName(Integer.toString(port));
    assertEquals("User", response);
  }
}