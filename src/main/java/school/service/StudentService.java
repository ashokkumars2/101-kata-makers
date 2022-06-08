package school.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.StudentEntity;
import school.exception.StudentDoesNotExistException;
import school.model.Course;
import school.model.Student;
import school.repository.StudentRepository;

@Service
public class StudentService {

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

    StudentEntity studentEntity = studentEntityOptional.orElseThrow(() -> new StudentDoesNotExistException(id));

    Student student = new Student();
    student.setFirstName(studentEntity.getFirstName());
    student.setLastName(studentEntity.getLastName());
    student.setAge(studentEntity.getAge());

    return student;
  }

  private void addStudentNumberTo(StudentEntity studentEntity) {

    String studentNumber = (studentEntity.getLastName() + studentEntity.getFirstName().charAt(0)).toLowerCase();

    List<String> likeStudentNumbers = studentRepository.findLikeStudentNumber(studentNumber);

    if(likeStudentNumbers.isEmpty()) {
      studentEntity.setStudentNumber(studentNumber);
    } else {
      OptionalInt lastNumber = likeStudentNumbers.stream()
          .map(likeStudentNumber -> likeStudentNumber.split("(?<=\\D)(?=\\d)"))
          .filter(splitStudentNumber -> splitStudentNumber.length > 1)
          .map(splitStudentNumber -> splitStudentNumber[1])
          .mapToInt(Integer::valueOf)
          .max();
      if (lastNumber.isPresent()) {
        studentEntity.setStudentNumber(studentNumber + (lastNumber.getAsInt() + 1));
      } else {
//        write test
      }
    }
  }
}
