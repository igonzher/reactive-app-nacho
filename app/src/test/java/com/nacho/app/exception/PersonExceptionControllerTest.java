package com.nacho.app.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;


public class PersonExceptionControllerTest {

    @Mock
    PersonNotFoundException personNotFoundException;

    @Mock
    PersonDniDuplicateException personDniDuplicateException;

    @InjectMocks
    PersonExceptionController personExceptionController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void PersonNotFoundException() {
       ResponseEntity<Object> result = personExceptionController.exception(new PersonNotFoundException());
       assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void PersonDniDuplicateException() {
        ResponseEntity<Object> result = personExceptionController.exception(new PersonDniDuplicateException());
        assertEquals(HttpStatus.CONFLICT, result.getStatusCode());
    }
}