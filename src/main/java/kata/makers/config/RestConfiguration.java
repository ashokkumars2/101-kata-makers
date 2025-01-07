package kata.makers.config;

import kata.makers.interceptor.RequestResponseLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfiguration {
  @Bean
  public RestClient restClient() {
    SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
    clientHttpRequestFactory.setReadTimeout(60000);

    BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(
        clientHttpRequestFactory);

    return RestClient.builder().requestFactory(bufferingClientHttpRequestFactory)
        .requestInterceptor(new RequestResponseLoggingInterceptor())
        .build();
  }
}
