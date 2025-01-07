package kata.makers.interceptor;

import static kata.makers.utils.ResponseUtil.responseToInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kata.makers.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

  private static final String MODIFIED_MESSAGE = "This is Interceptor saying hello!";

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
      ClientHttpRequestExecution execution) throws IOException {
    // read the request body
    log.info("Request: {} {} {}", request.getMethod(), request.getURI(), new String(body));

    ClientHttpResponse response = execution.execute(request, body);

    // Read the original response body
    byte[] responseBody = response.getBody().readAllBytes();
    log.info("Original response: {}", new String(responseBody));

    // Create a new ClientHttpResponse with the modified body
    return new ClientHttpResponse() {
      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
      }

      @Override
      public HttpStatusCode getStatusCode() throws IOException {
        return HttpStatusCode.valueOf(202);
      }

      @Override
      public String getStatusText() throws IOException {
        return null;
      }

      @Override
      public void close() {

      }

      @Override
      public InputStream getBody() throws IOException {
        Response response = Response.builder().id(1).message(MODIFIED_MESSAGE).build();
        return new ByteArrayInputStream(responseToInputStream(response).readAllBytes());
      }
    };
  }

}
