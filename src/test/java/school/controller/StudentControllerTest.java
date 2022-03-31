package school.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.core.JsonProcessingException;
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
import school.model.Student;
import school.service.StudentService;

import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

  public static final String STUDENT_URL = "/student";
  public static final String TEST_STUDENT_FIRST_NAME = "Ewa";
  public static final String TEST_STUDENT_LAST_NAME = "Jablonska";
  public static final int TEST_STUDENT_AGE = 18;
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

    when(studentService.createStudent(any(Student.class))).thenReturn(2L);

    mockMvc.perform(post(STUDENT_URL).contentType(MediaType.APPLICATION_JSON).content(payload))
        .andExpect(status().isOk())
            .andExpect(content().string("2"));
  }

  private Student getStudent() {
    Student student = new Student();
    student.setFirstName(TEST_STUDENT_FIRST_NAME);
    student.setLastName(TEST_STUDENT_LAST_NAME);
    student.setAge(TEST_STUDENT_AGE);
    return student;
  }

}