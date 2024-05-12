package com.org.hrms.exception;
import lombok.Getter;
import lombok.Setter;
import static com.org.hrms.utils.ErrorCode.NOT_FOUND;


@Setter
@Getter
public class EntityNotFoundException extends RuntimeException {

  private Integer statusCode;

  public EntityNotFoundException(String message, Integer statusCode) {
    super(message);
    setStatusCode(statusCode);
  }

  public static EntityNotFoundException employee(String message) {
    return new EntityNotFoundException(message, NOT_FOUND);
  }

}
