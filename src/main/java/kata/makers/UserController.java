package kata.makers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/username")
    public String getUserName() {
      // Replace with actual logic to retrieve the user name
      return "User";
    }
}

