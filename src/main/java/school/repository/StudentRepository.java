package school.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {


  StudentEntity findByFirstName(String firstName);

//  fix query
  @Query("SELECT u.studentNumber FROM Students u WHERE u.studentNumber LIKE '?1%'")
  List<String> findLikeStudentNumber(String studentNumber);
}
