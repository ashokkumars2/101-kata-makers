package school.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Course {

  String name;
  Integer credits;
  String professor;
}
