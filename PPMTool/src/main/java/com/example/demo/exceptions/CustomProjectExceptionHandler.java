package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomProjectExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<?> handleProjectException(ProjectIdException ex, WebRequest req){
             ProjectIdExceptionResponse projectIdExceptionResponse=new ProjectIdExceptionResponse(ex.getMessage());
             return  new  ResponseEntity(projectIdExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
