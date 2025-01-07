package kata.makers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/username")
    public String getUserName() {
      // Replace with actual logic to retrieve the user name
      log.info("Returning user name");

      return "User";
    }
}

