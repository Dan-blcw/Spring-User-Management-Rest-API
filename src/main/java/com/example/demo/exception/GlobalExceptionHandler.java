package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {
    /*
    cách khác :

          public ErrorResponse handlerNotFoundException(
                      NotFoundException ex,
                      WebRequest req
           ) {
          return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());

          lí do không dùng cách này vì không global
          =)) tk hương bảo "difficult to improve the product"
          còn lại phần exceptionhandler không cần phải giải thích vì quá easy,
          =)) nhể
    }
    */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handlerNotFoundException(
            ErrorResponse ex,
            WebRequest req
    ) {
        NotFoundException response = new  NotFoundException(ex.getMessage());
        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handlerDuplicateRecordException(
            ErrorResponse ex,
            WebRequest req
    ) {

        DuplicateRecordException response = new DuplicateRecordException(ex.getMessage());
        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handlerException(
            ErrorResponse ex,
            WebRequest req
    ) {
        Exception response = new Exception(ex.getMessage());
        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
