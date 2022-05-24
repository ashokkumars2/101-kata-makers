package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import school.model.Course;
import school.service.CourseService;

@RestController
public class CourseController {

  @Autowired
  CourseService courseService;

  @PostMapping("/course")
  public void createCourse(@RequestBody Course course) {
    courseService.createCourse(course);
  }

}
