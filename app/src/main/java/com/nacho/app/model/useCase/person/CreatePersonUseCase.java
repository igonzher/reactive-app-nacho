package com.nacho.app.model.useCase.person;


import com.nacho.app.model.mapper.PersonMapperModelImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import model.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreatePersonUseCase {

    PersonServiceImpl personService;
    PersonMapperModelImpl personMapper;

    public CreatePersonUseCase(PersonServiceImpl personService, PersonMapperModelImpl personMapperModel){
        this.personService = personService;
        this.personMapper = personMapperModel;
    }

    public Mono<Person> dispacth(com.nacho.app.model.Person person){
        return personService.createPerson(person).map(personCreated ->
                personMapper.personToPersonApi(personCreated)
        );
    }
}
