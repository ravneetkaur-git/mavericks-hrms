package com.org.hrms.exception;
import static com.org.hrms.utils.ErrorCode.BAD_REQUEST;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MandatoryFieldException extends RuntimeException {

  private Integer statusCode;

  public MandatoryFieldException(String message, Integer statusCode) {
    super(message);
    setStatusCode(statusCode);
  }

  public static MandatoryFieldException customer(String message) {
    return new MandatoryFieldException(message, BAD_REQUEST);
  }
}
