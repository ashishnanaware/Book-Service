package com.mastek.bookservice.exception;
import com.mastek.bookservice.payload.ApiResposnse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResposnse> getResourceNotFoundException(ResourceNotFoundException ex) {
        ApiResposnse build = ApiResposnse.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(build, HttpStatus.NOT_FOUND);
    }

}
