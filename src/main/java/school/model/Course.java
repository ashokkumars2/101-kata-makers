package school.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Course {

  String courseName;
  Integer credits;
  String professor;

  public Course(String courseName, Integer credits, String professor) {
    this.courseName = courseName;
    this.credits = credits;
    this.professor = professor;
  }
}
