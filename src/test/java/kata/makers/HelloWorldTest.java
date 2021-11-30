package kata.makers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {

  @Test
  public void shouldGreet() {
    assertEquals(HelloWorld.greet(), "Hello world!");
  }
}