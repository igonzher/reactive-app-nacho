package com.nacho.app.repository.mapper;


import com.nacho.app.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person personToPerson(Person target);
    @Mapping(target = "id", ignore = true)
    Person personToPerson(@MappingTarget Person target, Person source);

}
