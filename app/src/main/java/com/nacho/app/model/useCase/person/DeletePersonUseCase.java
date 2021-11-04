package com.nacho.app.model.useCase.person;


import com.nacho.app.model.mapper.PersonMapperModelImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeletePersonUseCase {

    PersonServiceImpl personService;
    PersonMapperModelImpl personMapper;

    public DeletePersonUseCase(PersonServiceImpl personService, PersonMapperModelImpl personMapperModel){
        this.personService = personService;
        this.personMapper = personMapperModel;
    }

    public Mono<Void> dispacth(String DNI){
        return personService.getPersonByDni(DNI).flatMap(personToDelete ->
            personService.deletePerson(personToDelete)
        );//.map(person -> person.getDni());

    }
}
