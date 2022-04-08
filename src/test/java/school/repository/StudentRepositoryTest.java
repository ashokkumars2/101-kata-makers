package school.repository;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import school.entity.StudentEntity;

@DataJpaTest
class StudentRepositoryTest {

  public static final String TEST_LAST_NAME = "Jablonska";
  public static final String TEST_FIRST_NAME = "Ewa";
  public static final int TEST_AGE = 18;
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  StudentRepository studentRepository;

  @Test
  public void shouldFindTheCorrectStudentFromDatabase() {

    createStudentEntityInDatabase();

    Assertions.assertEquals(TEST_LAST_NAME, studentRepository.findByFirstName(TEST_FIRST_NAME).getLastName());
  }

  @Test
  public void shouldFindTheCorrectStudentIdFromDatabase() {

    createStudentEntityInDatabase();

    Optional<StudentEntity> result = studentRepository.findById(1L);

    Assertions.assertEquals(TEST_FIRST_NAME, result.get().getFirstName());
  }

  private void createStudentEntityInDatabase() {
    StudentEntity studentEntity = new StudentEntity(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_AGE);

    studentRepository.save(studentEntity);
  }


}