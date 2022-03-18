package school.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import school.model.Student;
import school.service.StudentService;

import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  StudentService studentService;

  @InjectMocks
  private StudentController studentController;

  @Test
  public void shouldReturnOk() throws Exception {
    mockMvc.perform(post("/student"))
        .andExpect(status().isOk());
  }

  @Test
  public void shouldSendAStudentToTheStudentService() {
    Student student = new Student();
    studentController.createStudent(student);
    verify(studentService).createStudent(student);

  }

}