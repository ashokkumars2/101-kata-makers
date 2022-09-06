package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.exception.CourseDoesNotExistException;
import school.exception.StudentDoesNotExistException;
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
  public Student getStudent(@RequestParam("student-number") String studentNumber) throws StudentDoesNotExistException {
    return studentService.findStudentByStudentNumber(studentNumber);
  }

  @PostMapping("/enroll/{studentNumber}/{courseNumber}")
  public void enrollStudent(@PathVariable String studentNumber, @PathVariable String  courseNumber)
      throws StudentDoesNotExistException, CourseDoesNotExistException {
    studentService.enrollStudent(studentNumber, courseNumber);
  }
}
