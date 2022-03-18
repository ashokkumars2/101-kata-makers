package school.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import school.model.Student;

@RestController
public class StudentController {

  @PostMapping("/student")
  public void createStudent(Student student) {

  }


}
