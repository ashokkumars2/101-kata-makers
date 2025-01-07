package kata.makers.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kata.makers.model.Response;

public class ResponseUtil {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static InputStream responseToInputStream(Response response) throws IOException {
    return new ByteArrayInputStream(objectMapper.writeValueAsString(response).getBytes());
  }
}
