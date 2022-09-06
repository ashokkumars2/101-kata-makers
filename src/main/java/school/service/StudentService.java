package school.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.CourseEntity;
import school.entity.StudentEntity;
import school.exception.CourseDoesNotExistException;
import school.exception.StudentDoesNotExistException;
import school.model.Course;
import school.model.Student;
import school.repository.CourseRepository;
import school.repository.StudentRepository;

@Service
public class StudentService {

  private static final String REGEX_FOR_SPLITTING_LETTERS_AND_DIGITS = "(?<=\\D)(?=\\d)";
  private static final String REGEX_FOR_NON_ALPHABETICAL_CHARACTERS = "[^a-z]";
  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

  public String createStudent(Student student) {
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setFirstName(student.getFirstName());
    studentEntity.setLastName(student.getLastName());
    studentEntity.setAge(student.getAge());

    addStudentNumberTo(studentEntity);

    studentRepository.save(studentEntity);
    student.setStudentNumber(studentEntity.getStudentNumber());

    return studentEntity.getStudentNumber();
  }

  public Student findStudentByStudentNumber(String studentNumber) throws StudentDoesNotExistException {
    Optional<StudentEntity> studentEntityOptional = studentRepository.findByStudentNumber(studentNumber);

    StudentEntity studentEntity = studentEntityOptional.orElseThrow(
        () -> new StudentDoesNotExistException(studentNumber));

    Student student = Student.builder()
        .firstName(studentEntity.getFirstName())
        .lastName(studentEntity.getLastName())
        .age(studentEntity.getAge())
        .studentNumber(studentEntity.getStudentNumber())
        .build();

    List<Course> courses = studentEntity.getCoursesTaken()
        .stream()
        .map(courseEntity -> Course.builder().credits(courseEntity.getCredits())
            .professor(courseEntity.getProfessor()).name(courseEntity.getName()).courseNumber(courseEntity.getCourseNumber()).build())
        .collect(Collectors.toList());

    student.setCoursesTaken(courses);

    return student;
  }

  private void addStudentNumberTo(StudentEntity studentEntity) {

    String studentNumber = (studentEntity.getLastName() + studentEntity.getFirstName()
        .charAt(0)).toLowerCase().replaceAll(REGEX_FOR_NON_ALPHABETICAL_CHARACTERS, "");

    List<StudentEntity> likeStudentNumbers = studentRepository.findByStudentNumberLike(
        studentNumber + "%");

    if (likeStudentNumbers.isEmpty()) {
      studentEntity.setStudentNumber(studentNumber);
    } else {
      likeStudentNumbers.stream()
          .map(StudentEntity::getStudentNumber)
          .map(likeStudentNumber -> likeStudentNumber.split(REGEX_FOR_SPLITTING_LETTERS_AND_DIGITS))
          .filter(splitStudentNumber -> splitStudentNumber.length > 1)
          .map(splitStudentNumber -> splitStudentNumber[1])
          .mapToInt(Integer::valueOf)
          .max()
          .ifPresentOrElse(number -> studentEntity.setStudentNumber(studentNumber + (number + 1)),
              () -> studentEntity.setStudentNumber(studentNumber + 1));
    }
  }

  public void enrollStudent(String studentNumber, String courseEntityNumber)
      throws StudentDoesNotExistException, CourseDoesNotExistException {

    Optional<StudentEntity> studentEntityOptional = studentRepository.findByStudentNumber(
        studentNumber);
    StudentEntity studentEntity = studentEntityOptional.orElseThrow(
        () -> new StudentDoesNotExistException(studentNumber));

    Optional<CourseEntity> courseEntityOptional = courseRepository.findByCourseNumber(
        courseEntityNumber);
    CourseEntity courseEntity = courseEntityOptional.orElseThrow(
        () -> new CourseDoesNotExistException(courseEntityNumber));

    List<CourseEntity> studentCourses = new ArrayList<>(studentEntity.getCoursesTaken());
    studentCourses.add(courseEntity);
    studentEntity.setCoursesTaken(studentCourses);

    studentRepository.save(studentEntity);
  }
}
