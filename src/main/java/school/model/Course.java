package school.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Course {

  String name;
  Integer credits;
  String professor;
  String courseNumber;
}
