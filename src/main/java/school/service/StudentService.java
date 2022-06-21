package school.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.StudentEntity;
import school.exception.StudentDoesNotExistException;
import school.model.Student;
import school.repository.StudentRepository;

@Service
public class StudentService {

  public static final String REGEX_FOR_SPLITTING_LETTERS_AND_DIGITS = "(?<=\\D)(?=\\d)";
  @Autowired
  StudentRepository studentRepository;

  public String createStudent(Student student) {
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setFirstName(student.getFirstName());
    studentEntity.setLastName(student.getLastName());
    studentEntity.setAge(student.getAge());

    addStudentNumberTo(studentEntity);

    studentRepository.save(studentEntity);

    return studentEntity.getStudentNumber();
  }

  public Student findStudentById(long id) throws StudentDoesNotExistException {
    Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);

    StudentEntity studentEntity = studentEntityOptional.orElseThrow(
        () -> new StudentDoesNotExistException(id));

    Student student = new Student();
    student.setFirstName(studentEntity.getFirstName());
    student.setLastName(studentEntity.getLastName());
    student.setAge(studentEntity.getAge());

    return student;
  }

  private void addStudentNumberTo(StudentEntity studentEntity) {

    String studentNumber = (studentEntity.getLastName() + studentEntity.getFirstName()
        .charAt(0)).toLowerCase();

    List<StudentEntity> likeStudentNumbers = studentRepository.findByStudentNumberLike(studentNumber + "%");

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
}
