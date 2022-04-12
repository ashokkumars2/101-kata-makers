package school.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.StudentEntity;
import school.exception.StudentDoesNotExistException;
import school.model.Student;
import school.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  public Long createStudent(Student student) {
    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setFirstName(student.getFirstName());
    studentEntity.setLastName(student.getLastName());
    studentEntity.setAge(student.getAge());

    StudentEntity studentEntityResponse = studentRepository.save(studentEntity);

    return studentEntityResponse.getId();
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
}
