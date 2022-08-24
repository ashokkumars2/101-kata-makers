package school.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school.entity.CourseEntity;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Long> {


  CourseEntity findByName(String name);

  Optional<CourseEntity> findByCourseNumber(String courseNumber);
}
