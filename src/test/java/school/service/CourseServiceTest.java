package school.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import school.entity.CourseEntity;
import school.model.Course;
import school.repository.CourseRepository;


class CourseServiceTest {

  private static final String TEST_COURSE_NAME = "English";
  private static final Integer TEST_COURSE_CREDITS = 100;
  private static final String TEST_COURSE_PROFESSOR = "Professor Jablonska";

  @Mock
  private CourseRepository courseRepository;

  @InjectMocks
  CourseService courseService;

  @Captor
  ArgumentCaptor<CourseEntity> courseEntityCaptor;
  @BeforeEach
  public void setUp() {
    openMocks(this);
  }

  @Test
  public void shouldSendTheCourseToTheRepository() {

    CourseEntity courseEntity = new CourseEntity();

    when(courseRepository.save(any())).thenReturn(courseEntity);

    courseService.createCourse(getCourse());

    verify(courseRepository).save(courseEntityCaptor.capture());

    CourseEntity result = courseEntityCaptor.getValue();

    Assertions.assertEquals(TEST_COURSE_NAME, result.getName());
    Assertions.assertEquals(TEST_COURSE_CREDITS, result.getCredits());
    Assertions.assertEquals(TEST_COURSE_PROFESSOR, result.getProfessor());
  }

  private Course getCourse() {

    return Course.builder()
        .name(TEST_COURSE_NAME)
        .credits(TEST_COURSE_CREDITS)
        .professor(TEST_COURSE_PROFESSOR)
        .build();
  }
}