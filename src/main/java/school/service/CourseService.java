package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.CourseEntity;
import school.model.Course;
import school.repository.CourseRepository;

@Service
public class CourseService {

  @Autowired
  CourseRepository courseRepository;

  public void createCourse(Course course) {

    CourseEntity courseEntity = new CourseEntity();
    courseEntity.setName(course.getName());
    courseEntity.setCredits(course.getCredits());
    courseEntity.setProfessor(course.getProfessor());

    courseRepository.save(courseEntity);
  }

}
