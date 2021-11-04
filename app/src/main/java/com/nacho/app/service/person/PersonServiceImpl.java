package com.nacho.app.service.person;


import com.nacho.app.exception.PersonDniDuplicateException;
import com.nacho.app.exception.PersonNotFoundException;
import com.nacho.app.model.Person;
import com.nacho.app.repository.PersonRepository;
import com.nacho.app.repository.mapper.PersonMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService{

    PersonRepository personRepository;
    PersonMapperImpl personMapper;

    @Autowired
    PersonServiceImpl(PersonRepository personRepository, PersonMapperImpl personMapper){
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public  Mono<Person> createPerson(Person person) {

        if(personRepository.findByDni(person.getDni()).block() != null){

            throw new PersonDniDuplicateException();
        }
        Mono<Person> personCreated = personRepository.save(person);
        return personCreated;
    }

    @Override
    public Mono<Person> updatePerson(Person person) {

        Person personToUpdate = personRepository.findByDni(person.getDni()).block();

        personToUpdate = personMapper.personToPerson(personToUpdate, person);
        Mono<Person> personUpdated =  personRepository.save(personToUpdate);

        return personUpdated;
    }

    @Override
    public Mono<Void> deletePerson(Person person) {
        return personRepository.delete(person);
    }

    @Override
    public Flux<Person> getPeople() {
        return personRepository.findAll();
    }

    @Override
    public Mono<Person> getPersonByDni(String dni) {

        Person person = personRepository.findByDni(dni).block();

        if (person != null){
            return personRepository.findByDni(dni);
        } else {
            throw new PersonNotFoundException();
        }
    }

    @Override
    public Flux<Person> getPersonByName(String name) {

        List<Person> personList = personRepository.findByName(name).collectList().block();
        if (personList != null){
            return  personRepository.findByName(name);
        } else {
            throw new PersonNotFoundException();
        }
    }

}
