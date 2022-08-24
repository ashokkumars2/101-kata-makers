package school.model;

import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Student {

  private String firstName;
  private String lastName;
  private Integer age;
  private List<Course> coursesTaken;
  private String studentNumber;
}
