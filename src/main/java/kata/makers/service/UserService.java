package kata.makers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserService {

  @Autowired
  RestClient restClient;

  public String getUserName(String port) {
    return restClient.get().uri("http://localhost:" + port + "/username").retrieve().body(String.class);
  }

}
