package school.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import school.exception.CourseDoesNotExistException;
import school.exception.StudentDoesNotExistException;
import school.model.Student;
import school.service.StudentService;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

  public static final String STUDENT_URL = "/student";
  public static final String STUDENTS_URL = "/students";
  public static final String TEST_STUDENT_FIRST_NAME = "Ewa";
  public static final String TEST_STUDENT_LAST_NAME = "Jablonska";
  public static final int TEST_STUDENT_AGE = 18;
  public static final String TEST_STUDENT_NUMBER = "jablonskae";
  public static final String TEST_COURSE_ENTITY_NUMBER = "ENG";

  @Captor
  ArgumentCaptor<Student> studentArgumentCaptor;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  StudentService studentService;

  @InjectMocks
  private StudentController studentController;

  @BeforeEach
  public void setUp() {
    openMocks(this);
  }

  @Test
  public void shouldSendAStudentWithCorrectParametersToTheStudentService() throws Exception {

    String payload = new ObjectMapper().writeValueAsString(getStudent());

    mockMvc.perform(post(STUDENT_URL).contentType(MediaType.APPLICATION_JSON).content(payload))
        .andExpect(status().isOk());

    verify(studentService).createStudent(studentArgumentCaptor.capture());
    Student result = studentArgumentCaptor.getValue();
    Assertions.assertThat(TEST_STUDENT_FIRST_NAME).isEqualTo(result.getFirstName());
    Assertions.assertThat(TEST_STUDENT_LAST_NAME).isEqualTo(result.getLastName());
    Assertions.assertThat(TEST_STUDENT_AGE).isEqualTo(result.getAge());
  }

  @Test
  public void shouldReturnCorrectStudentIdFromService() throws Exception {

    String payload = new ObjectMapper().writeValueAsString(getStudent());

    when(studentService.createStudent(any(Student.class))).thenReturn("abc");

    mockMvc.perform(post(STUDENT_URL).contentType(MediaType.APPLICATION_JSON).content(payload))
        .andExpect(status().isOk())
        .andExpect(content().string("abc"));
  }

  @Test
  public void shouldGetStudent() throws Exception, StudentDoesNotExistException {

    when(studentService.findStudentById(1L)).thenReturn(getStudent());

    mockMvc.perform(
            get(STUDENTS_URL).contentType(MediaType.APPLICATION_JSON).queryParam("student-id", "1"))
        .andExpect(status().isOk())
        .andExpect(content().string(new ObjectMapper().writeValueAsString(getStudent())));
  }

  @Test
  public void shouldEnrollStudentToACourse()
      throws Exception, StudentDoesNotExistException, CourseDoesNotExistException {

    mockMvc.perform(post("/enroll/{studentNumber}/{courseNumber}", TEST_STUDENT_NUMBER,
            TEST_COURSE_ENTITY_NUMBER))
        .andExpect(status().isOk())
        .andReturn();

    verify(studentService).enrollStudent(TEST_STUDENT_NUMBER, TEST_COURSE_ENTITY_NUMBER);
  }

  private Student getStudent() {
    return Student.builder()
        .firstName(TEST_STUDENT_FIRST_NAME)
        .lastName(TEST_STUDENT_LAST_NAME)
        .age(TEST_STUDENT_AGE)
        .build();
  }

}