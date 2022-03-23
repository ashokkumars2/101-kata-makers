package school.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

  private Long id;
  private String firstName;
  private String lastName;
  private Integer age;
}
