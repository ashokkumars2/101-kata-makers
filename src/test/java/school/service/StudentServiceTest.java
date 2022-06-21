package school.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import school.entity.StudentEntity;
import school.exception.StudentDoesNotExistException;
import school.model.Student;
import school.repository.StudentRepository;

public class StudentServiceTest {

  public static final String TEST_STUDENT_FIRST_NAME = "Ewa";
  public static final String TEST_STUDENT_LAST_NAME = "Jablonska";
  public static final int TEST_STUDENT_AGE = 18;
  public static final long TEST_ID = 1L;
  public static final String TEST_STUDENT_NUMBER = "jablonskae";
  public static final String TEST_STUDENT_NUMBER_UNIQUE_3 = "jablonskae3";
  public static final String TEST_STUDENT_NUMBER_UNIQUE_1 = "jablonskae1";

  @Mock
  private StudentRepository studentRepository;

  @InjectMocks
  private StudentService studentService;

  @Captor
  ArgumentCaptor<StudentEntity> argumentCaptor;

  @BeforeEach
  public void setUp() {
    openMocks(this);
  }

  @Test
  public void willSaveStudentInTheRepository() {

    StudentEntity studentEntity = new StudentEntity();

    when(studentRepository.save(any())).thenReturn(studentEntity);

    studentService.createStudent(getStudent());

    verify(studentRepository).save(argumentCaptor.capture());

    StudentEntity result = argumentCaptor.getValue();

    Assertions.assertEquals(TEST_STUDENT_FIRST_NAME, result.getFirstName());
    Assertions.assertEquals(TEST_STUDENT_LAST_NAME, result.getLastName());
    Assertions.assertEquals(TEST_STUDENT_AGE, result.getAge());
    Assertions.assertEquals(TEST_STUDENT_NUMBER, result.getStudentNumber());

  }

  @Test
  public void willReturnStudentEntityIdWhenSavingStudentToDatabase() {

    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setId(TEST_ID);

    when(studentRepository.save(any())).thenReturn(studentEntity);

    Assertions.assertEquals(TEST_STUDENT_NUMBER, studentService.createStudent(getStudent()));
  }

  @Test
  public void shouldReturnTheCorrectStudentWhenFindingById() throws StudentDoesNotExistException {

    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setId(TEST_ID);
    studentEntity.setFirstName(TEST_STUDENT_FIRST_NAME);

    when(studentRepository.findById(any())).thenReturn(Optional.of(studentEntity));

    Assertions.assertEquals(TEST_STUDENT_FIRST_NAME, studentService.findStudentById(TEST_ID).getFirstName());
  }

  @Test
  public void shouldThrowExceptionWhenStudentDoesNotExist() {

    when(studentRepository.findById(any())).thenReturn(Optional.empty());

    Assertions.assertThrows(StudentDoesNotExistException.class,
        () -> studentService.findStudentById(TEST_ID));
  }

  @Test
  void shouldCreateUniqueStudentNumberIfNameAlreadyExists() {

    ArrayList<StudentEntity> result = new ArrayList<>();
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setStudentNumber(TEST_STUDENT_NUMBER);
    StudentEntity studentEntityTwo = new StudentEntity();
    studentEntityTwo.setStudentNumber(TEST_STUDENT_NUMBER_UNIQUE_1);
    StudentEntity studentEntityThree = new StudentEntity();
    studentEntityThree.setStudentNumber("jablonskae2");
    result.add(studentEntity);
    result.add(studentEntityTwo);
    result.add(studentEntityThree);
    when(studentRepository.findByStudentNumberLike(TEST_STUDENT_NUMBER)).thenReturn(
        result);
    String result2 = studentService.createStudent(getStudent());

    Assertions.assertEquals(TEST_STUDENT_NUMBER_UNIQUE_3, result2);
  }

  @Test
  void shouldCreateUniqueStudentNumberIfNameDoesNotExist() {

    when(studentRepository.findByStudentNumberLike(TEST_STUDENT_NUMBER)).thenReturn(new ArrayList<>());
    String result = studentService.createStudent(getStudent());

    Assertions.assertEquals(TEST_STUDENT_NUMBER, result);
  }

  @Test
  void shouldCreateUniqueStudentNumberIfOneNameExistsInDatabase() {

    ArrayList<StudentEntity> array = new ArrayList<>();
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setStudentNumber(TEST_STUDENT_NUMBER);
    array.add(studentEntity);
    when(studentRepository.findByStudentNumberLike(TEST_STUDENT_NUMBER)).thenReturn(array);
    String result = studentService.createStudent(getStudent());

    Assertions.assertEquals(TEST_STUDENT_NUMBER_UNIQUE_1, result);
  }

  @Test
  public void shouldAlwaysCallFindByStudentNumberLikeWithAWildcard() {

    Student student = new Student();
    student.setFirstName("Susan");
    student.setLastName("Smith");
    studentService.createStudent(student);
    verify(studentRepository).findByStudentNumberLike("smiths%");
  }

  private Student getStudent() {
    Student student = new Student();

    student.setFirstName(StudentServiceTest.TEST_STUDENT_FIRST_NAME);
    student.setLastName(StudentServiceTest.TEST_STUDENT_LAST_NAME);
    student.setAge(StudentServiceTest.TEST_STUDENT_AGE);
    return student;
  }

}
