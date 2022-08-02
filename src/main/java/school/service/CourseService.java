package school.service;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
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
    courseEntity.setCourseNumber(getCourseNumber(course));

    courseRepository.save(courseEntity);
  }

  private String getCourseNumber(Course course) {
    String[] splitCourseName = course.getName().split(" ");
    return Arrays.stream(splitCourseName)
        .map(word -> word.length() > 2 ?
            word.substring(0, 3).toUpperCase(Locale.ROOT) :
            word.toUpperCase(Locale.ROOT))
        .collect(Collectors.joining("_"));
  }

}
