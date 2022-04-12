package school.exception;

public class StudentDoesNotExistException extends Throwable {

  public StudentDoesNotExistException(Long id) {
    super(String.format("Could not find a student with id=%s", id));
  }
}
