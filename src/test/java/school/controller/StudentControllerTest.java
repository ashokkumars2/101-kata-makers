package school.controller;

import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
  public void shouldReturnOk() throws Exception {
    mockMvc.perform(post("/student"))
        .andExpect(status().isOk());
  }

  @Test
  public void shouldSendAStudentToTheStudentService() throws Exception {
    Student student = new Student();
    studentController.createStudent(student);
//    mockMvc.perform(post("/student").contentType(MediaType.APPLICATION_JSON).content("{}"))
//        .andExpect(status().isOk());
    verify(studentService).createStudent(student);

  }

}