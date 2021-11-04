package com.nacho.app.model.useCase.person;


import com.nacho.app.model.mapper.PersonMapperModelImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import model.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdatePersonUseCase {

    PersonServiceImpl personService;
    PersonMapperModelImpl personMapper;

    public UpdatePersonUseCase(PersonServiceImpl personService, PersonMapperModelImpl personMapperModel){
        this.personService = personService;
        this.personMapper = personMapperModel;
    }

    public Mono<Person> dispacth(com.nacho.app.model.Person person){
        return personService.getPersonByDni(person.getDni()).map(personToCreate ->
                    personMapper.personToPerson(personToCreate, person)
                ).flatMap(personToCreate ->
                        personService.createPerson(personToCreate)
                    ).map(personUpdated -> personMapper.personToPersonApi(personUpdated));
    }
}