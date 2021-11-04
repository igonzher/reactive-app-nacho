package com.nacho.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Bill {

    /*@Transient
    public static final String SEQUENCE_NAME = "users_sequence";*/

    @Id
    private String id;

    private Long billId;
    private Integer amount;
    private Date date;
    private Person person;
    private Product product;
}
