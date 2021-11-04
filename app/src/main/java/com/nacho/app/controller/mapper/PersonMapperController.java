package com.nacho.app.controller.mapper;

import com.nacho.app.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapperController {

    model.Person personToPersonApi(Person source);
    Person personApiToPerson(model.Person source);
    List<model.Person> peopleToPeopleApi(List<Person> source);
    List<Person> peopleApiToPeople(List<model.Person> source);
}
