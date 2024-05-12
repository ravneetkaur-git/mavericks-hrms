package com.org.hrms.exception;
import static com.org.hrms.utils.ErrorCode.NOT_FOUND;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntityAlreadyExistsException extends RuntimeException {

  private Integer statusCode;

  public EntityAlreadyExistsException(String message, Integer statusCode) {
    super(message);
    setStatusCode(statusCode);
  }

  public static EntityAlreadyExistsException employee(String message) {
    return new EntityAlreadyExistsException(message, NOT_FOUND);
  }

}
