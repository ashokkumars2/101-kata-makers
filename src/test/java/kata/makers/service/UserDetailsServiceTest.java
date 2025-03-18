package kata.makers.service;

import static org.junit.jupiter.api.Assertions.*;

import kata.makers.model.User;
import org.junit.jupiter.api.Test;

class UserDetailsServiceTest {

  private final UserDetailsService userDetailsService = new UserDetailsService();

  @Test
  public void ListAllUsers() {

    assertEquals(1, userDetailsService.getAllUsers().size());
    assertEquals("John Doe", userDetailsService.getAllUsers().get(1).name());
//    assertEquals(1, userDetailsService.getAllUsers().get(0));
  }

  @Test
  public void shouldReturnUserById() {
    assertEquals("John Doe", userDetailsService.getUserById(1).name());
  }

  @Test
  public void shouldNotReturnUserById() {
    assertNull(userDetailsService.getUserById(2));
  }

  @Test
  public void createUser() {
    User user = new User(2, "Jason", null, null, null, null, null, null, null, null);
    userDetailsService.createUser(user);
    assertEquals("Jason", userDetailsService.getAllUsers().get(2).name());
    assertEquals(2, userDetailsService.getAllUsers().size());
  }
}