package school.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import school.entity.CourseEntity;

@DataJpaTest
class CourseRepositoryTest {

  @Autowired
  CourseRepository courseRepository;

  @Test
  public void shouldCreateAndFindACourse() {

    CourseEntity courseEntity = new CourseEntity();
    courseEntity.setName("History");
    courseEntity.setProfessor("Professor Ashton");
    courseEntity.setCredits(10);

    courseRepository.save(courseEntity);
    CourseEntity result = courseRepository.findByName("History");
    Assertions.assertEquals("Professor Ashton", result.getProfessor());
    Assertions.assertEquals(10, result.getCredits());
  }


}