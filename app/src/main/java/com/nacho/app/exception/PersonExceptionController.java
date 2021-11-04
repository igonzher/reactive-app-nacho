package com.nacho.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

@ControllerAdvice
public class PersonExceptionController {

    @ResponseBody
    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<Object> exception(PersonNotFoundException exception){

        return new ResponseEntity<>(new Json("ID Person not found"), HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = PersonDniDuplicateException.class)
    public ResponseEntity<Object> exception(PersonDniDuplicateException exception){

        return new ResponseEntity<>(new Json("Person DNI is duplicate"), HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(value = ProductNameDuplicateException.class)
    public ResponseEntity<Object> exception(ProductNameDuplicateException exception){

        return new ResponseEntity<>(new Json("Product name is duplicate"), HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception){

        return new ResponseEntity<>(new Json("Product not found"), HttpStatus.CONFLICT);
    }
}
