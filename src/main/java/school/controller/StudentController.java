package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.model.Student;
import school.service.StudentService;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping("/student")
  public Long createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
  }


}
