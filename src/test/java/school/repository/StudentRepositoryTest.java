package school.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.ActiveProfiles;
import school.entity.StudentEntity;

@ActiveProfiles("test")
@DataJpaTest
class StudentRepositoryTest {

  public static final String TEST_LAST_NAME = "Jablonska";
  public static final String TEST_FIRST_NAME = "Ewa";
  public static final int TEST_AGE = 18;
  public static final String TEST_STUDENT_NUMBER = "jablonskae";
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

    Optional<StudentEntity> result = studentRepository.findById(7L);

    Assertions.assertEquals(TEST_FIRST_NAME, result.get().getFirstName());
  }


//  ashtonl -> ashtonl, ashtonl1, ashtonl2, ashtonlcomputer
  @Test
  public void shouldReturnAListOfStudentNumbersThatMatchStudentName() {
    StudentEntity studentEntity = new StudentEntity("Susan", "Smith", TEST_AGE, "smiths");
    studentRepository.save(studentEntity);
    ArrayList<StudentEntity> result = studentRepository.findByStudentNumberLike("smiths");
    Assertions.assertEquals(List.of(studentEntity), result);
  }

  @Test
  public void shouldReturnAListOfStudentNumbersThatMatchStudentNameAndAnythingAfter() {
    StudentEntity studentEntity = new StudentEntity("Susan", "Smithson", TEST_AGE, "smithsons");
    studentRepository.save(studentEntity);
    ArrayList<StudentEntity> result = studentRepository.findByStudentNumberLike("smiths%");
    Assertions.assertEquals(List.of(studentEntity), result);
  }

  private void createStudentEntityInDatabase() {
    StudentEntity studentEntity = new StudentEntity(TEST_FIRST_NAME, TEST_LAST_NAME, TEST_AGE,
        TEST_STUDENT_NUMBER);

    studentRepository.save(studentEntity);
  }


}