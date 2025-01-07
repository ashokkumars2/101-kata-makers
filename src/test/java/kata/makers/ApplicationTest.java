package kata.makers;


import static org.junit.jupiter.api.Assertions.assertTrue;

import kata.makers.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

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
    assertTrue(response.contains("\"message\":\"This is Interceptor saying hello!\""));
    assertTrue(response.contains("\"id\":1"));
  }
}