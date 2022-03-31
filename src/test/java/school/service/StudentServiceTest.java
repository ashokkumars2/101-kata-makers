package school.service;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import school.controller.StudentController;
import school.entity.StudentEntity;
import school.model.Student;
import school.repository.StudentRepository;

public class StudentServiceTest {

  public static final String TEST_STUDENT_FIRST_NAME = "Ewa";
  public static final String TEST_STUDENT_LAST_NAME = "Jablonska";
  public static final int TEST_STUDENT_AGE = 18;

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
    Student student = new Student();

    student.setFirstName(TEST_STUDENT_FIRST_NAME);
    student.setLastName(TEST_STUDENT_LAST_NAME);
    student.setAge(TEST_STUDENT_AGE);

    studentService.createStudent(student);

    verify(studentRepository).save(argumentCaptor.capture());

    StudentEntity result = argumentCaptor.getValue();

    Assertions.assertEquals(TEST_STUDENT_FIRST_NAME, result.getFirstName());
    Assertions.assertEquals(TEST_STUDENT_LAST_NAME, result.getLastName());
    Assertions.assertEquals(TEST_STUDENT_AGE, result.getAge());

  }
}
