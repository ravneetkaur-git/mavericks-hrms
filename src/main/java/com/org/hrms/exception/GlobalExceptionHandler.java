package com.org.hrms.exception;

import static com.org.hrms.utils.ErrorCode.INTERNAL_SERVER_ERROR;
import com.org.hrms.exception.EntityAlreadyExistsException;
import com.org.hrms.exception.EntityNotFoundException;
import com.org.hrms.exception.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public @ResponseBody ErrorMessage handleException(final Exception e,
      final HttpServletRequest request) {

    return ErrorMessage.builder()
        .status(false)
        .message(e.getMessage())
        .build();
  }

  @ExceptionHandler({EntityNotFoundException.class})
  public @ResponseBody ErrorMessage entityNotFoundException(
      EntityNotFoundException e, final HttpServletRequest request) {
    return ErrorMessage.builder()
        .status(false)
        .message(e.getMessage())
        .build();
  }

  @ExceptionHandler({EntityAlreadyExistsException.class})
  public @ResponseBody ErrorMessage entityAlreadyExistsException(
      EntityAlreadyExistsException e, final HttpServletRequest request) {
    return ErrorMessage.builder()
        .status(false)
        .message(e.getMessage())
        .build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public @ResponseBody ErrorMessage handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpStatus httpStatus) {
    return ErrorMessage.builder()
        .status(false)
        .message(ex.getMessage())
        .build();
  }
}
