package school.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import school.model.Course;

@Getter
@Setter
@Entity
@Table(name = "students")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "first_name")
  String firstName;
  @Column(name = "last_name")
  String lastName;
  @Column(name = "age")
  Integer age;
  @Column (name = "student_number")
  String studentNumber;

  @ManyToMany
  @JoinTable(
      name = "courses_taken",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "course_id"))
  Set<CourseEntity> coursesTaken;


  public StudentEntity(String firstName, String lastName, Integer age, String studentNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.studentNumber = studentNumber;
  }

  public StudentEntity() {
  }

}
