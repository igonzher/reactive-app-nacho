package com.nacho.app.model.mapper;

import com.nacho.app.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapperModel {

    model.Person personToPersonApi(Person source);
    Person personApiToPerson(model.Person source);
    List<model.Person> peopleToPeopleApi(List<Person> source);
    List<Person> peopleApiToPeople(List<model.Person> source);

    @Mapping(target = "id", ignore = true)
    Person personToPerson(@MappingTarget Person target, Person source);
}
