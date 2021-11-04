package com.nacho.app.model.useCase.person;


import com.nacho.app.model.mapper.PersonMapperModelImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import model.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GetPeopleUseCase {

    PersonServiceImpl personService;
    PersonMapperModelImpl personMapper;

    public  GetPeopleUseCase(PersonServiceImpl personService, PersonMapperModelImpl personMapperModel){
        this.personService = personService;
        this.personMapper = personMapperModel;
    }

    public Mono<List<Person>> dispacth(){
        return personService.getPeople().map(person ->
                personMapper.personToPersonApi(person)
        ).collectList();
    }
}
