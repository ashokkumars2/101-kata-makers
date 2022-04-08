package school.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import school.entity.StudentEntity;
import school.model.Student;
import school.repository.StudentRepository;

public class StudentServiceTest {

  public static final String TEST_STUDENT_FIRST_NAME = "Ewa";
  public static final String TEST_STUDENT_LAST_NAME = "Jablonska";
  public static final int TEST_STUDENT_AGE = 18;
  public static final long TEST_ID = 1L;

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

  }

  @Test
  public void willReturnStudentEntityIdWhenSavingStudentToDatabase() {

    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setId(TEST_ID);

    when(studentRepository.save(any())).thenReturn(studentEntity);

    Assertions.assertEquals(TEST_ID, studentService.createStudent(getStudent()));
  }

  @Test
  public void shouldReturnTheCorrectStudentWhenFindingById() {

    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setId(TEST_ID);
    studentEntity.setFirstName(TEST_STUDENT_FIRST_NAME);

    when(studentRepository.findById(any())).thenReturn(Optional.of(studentEntity));

    Assertions.assertEquals(TEST_STUDENT_FIRST_NAME, studentService.findStudentById(TEST_ID).getFirstName());
  }

  private Student getStudent() {
    Student student = new Student();

    student.setFirstName(StudentServiceTest.TEST_STUDENT_FIRST_NAME);
    student.setLastName(StudentServiceTest.TEST_STUDENT_LAST_NAME);
    student.setAge(StudentServiceTest.TEST_STUDENT_AGE);
    return student;
  }

}
