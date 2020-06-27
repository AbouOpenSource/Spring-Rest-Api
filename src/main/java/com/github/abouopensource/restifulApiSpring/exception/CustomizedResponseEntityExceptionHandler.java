package com.github.abouopensource.restifulApiSpring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(Exception.class)
        public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request){
            ExceptionResponse ex   =  new ExceptionResponse(new Date(),exception.getMessage(), request.getDescription(false));

          return   new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception exception, WebRequest request){
        ExceptionResponse ex   =  new ExceptionResponse(new Date(),exception.getMessage(), request.getDescription(false));

        return   new ResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status,WebRequest request){
        ExceptionResponse ex   =  new ExceptionResponse(new Date(),e.getMessage(), e.getBindingResult().toString());

        return   new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
    }
}
