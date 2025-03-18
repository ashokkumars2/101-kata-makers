package kata.makers.controller;

import java.util.List;
import java.util.Set;
import kata.makers.model.User;
import kata.makers.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {

  @Autowired
  private UserDetailsService userDetailsService;

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUserDetails() {
    userDetailsService.getAllUsers();

    return ResponseEntity.ok().body(userDetailsService.getAllUsers());
  }
}
