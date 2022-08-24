package school.exception;

public class CourseDoesNotExistException extends Throwable {

  public CourseDoesNotExistException(String message) {
    super(message);
  }

  public CourseDoesNotExistException(Long id) {
    super(String.format("Could not find a course with id=%s", id));
  }
}
