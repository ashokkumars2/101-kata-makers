package kata.makers.service;



import java.util.HashMap;
import java.util.List;
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

  public Map<Integer, User> getAllUsers() {
    return users;
  }

  public User getUserById(int id) {
    return users.get(id);
  }
}
