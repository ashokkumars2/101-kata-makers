package kata.makers.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDetailsServiceTest {

  private final UserDetailsService userDetailsService = new UserDetailsService();

  @Test
  public void ListAllUsers() {
    assertEquals(1, userDetailsService.getAllUsers().size());
  }

}