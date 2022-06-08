package school.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {


  StudentEntity findByFirstName(String firstName);

  List<String> findLikeStudentNumber(String studentNumber);
}
