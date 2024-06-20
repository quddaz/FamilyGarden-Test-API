package DataTest.demo.Exception.Advice;

import DataTest.demo.Base.ResponseDto;
import DataTest.demo.Exception.ApiException;
import DataTest.demo.Exception.Enum.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApiExceptionAdvice {
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ResponseDto<?>> apiExceptionHandler(ApiException e) {
    ErrorCode errorCode = e.getErrorCode();
    ResponseDto<?> response = ResponseDto.fail(errorCode.getHttpStatus().value(), errorCode.getMessage() + " " + e.getMessage());
    return ResponseEntity.status(errorCode.getHttpStatus()).body(response);
  }

}
