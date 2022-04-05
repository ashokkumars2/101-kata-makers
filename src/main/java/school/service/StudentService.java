package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.entity.StudentEntity;
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
}
