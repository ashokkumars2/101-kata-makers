package school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.exception.StudentDoesNotExistException;
import school.model.Course;
import school.model.Student;
import school.service.StudentService;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping("/student")
  public String createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
  }

  @GetMapping("/students")
  public Student getStudent(@RequestParam("student-id") Long id) throws StudentDoesNotExistException {
    return studentService.findStudentById(id);
  }

}
