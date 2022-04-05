package school.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import school.entity.StudentEntity;

@DataJpaTest
class StudentRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  StudentRepository studentRepository;

  @Test
  public void shouldFindTheCorrectStudentFromDatabase() {

    StudentEntity studentEntity = new StudentEntity("Ewa", "Jablonska", 18);

    studentRepository.save(studentEntity);

    Assertions.assertEquals("Jablonska", studentRepository.findByFirstName("Ewa").getLastName());
  }


}