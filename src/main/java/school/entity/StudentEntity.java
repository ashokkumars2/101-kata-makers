package school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  String firstName;
  String lastName;
  Integer age;

  public StudentEntity(String firstName, String lastName, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public StudentEntity() {
  }

}
