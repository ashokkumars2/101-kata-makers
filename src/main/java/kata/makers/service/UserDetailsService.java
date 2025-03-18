package kata.makers.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kata.makers.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

  private static final Map<Integer, User> users = new HashMap<>();
  static {
    users.put(1, new User("John Doe", null, null, null, null, null, null, null, null));
  }

  public Set<User> getAllUsers() {
    return Set.copyOf(users.values());
  }
}
