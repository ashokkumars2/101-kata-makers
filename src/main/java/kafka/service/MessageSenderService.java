package kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MessageSenderService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${spring.kafka.bootstrap-servers}")
  private String secondTopicUrl;

  public void sendMessage(String message) {

    log.info("Sending message to second topic: message={}, url={}", message, secondTopicUrl);

    ResponseEntity<String> responseEntity = restTemplate
        .exchange(secondTopicUrl, HttpMethod.POST, buildHttpEntity(message), String.class);
  }


  private HttpEntity<String> buildHttpEntity(String message) {
    final MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    return new HttpEntity<>(message, headers);
  }
}
