package com.nacho.app.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Person {

    @Id
    private String id;

    private String dni;
    private String name;
    private Integer age;

}


