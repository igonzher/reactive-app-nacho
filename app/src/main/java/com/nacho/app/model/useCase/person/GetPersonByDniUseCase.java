package com.nacho.app.model.useCase.person;


import com.nacho.app.model.mapper.PersonMapperModelImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import model.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetPersonByDniUseCase {

    PersonServiceImpl personService;
    PersonMapperModelImpl personMapper;

    public GetPersonByDniUseCase(PersonServiceImpl personService, PersonMapperModelImpl personMapperModel){
        this.personService = personService;
        this.personMapper = personMapperModel;
    }

    public Mono<Person> dispacth(String dni){
        return personService.getPersonByDni(dni).map(person ->
                personMapper.personToPersonApi(person)
        );
    }
}
