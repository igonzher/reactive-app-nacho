package com.nacho.app.service.person;


import com.nacho.app.exception.PersonDniDuplicateException;
import com.nacho.app.exception.PersonNotFoundException;
import com.nacho.app.model.Person;
import com.nacho.app.repository.PersonRepository;
import com.nacho.app.repository.mapper.PersonMapperImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


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

        if(ObjectUtils.isNotEmpty(personRepository.findByDni(person.getDni()))){

            throw new PersonDniDuplicateException();
        }
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> updatePerson(Person person) {
        return personRepository.save(person);
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

        Mono<Person> person = personRepository.findByDni(dni);

        if (ObjectUtils.isNotEmpty(person)){
            return personRepository.findByDni(dni);
        } else {
            throw new PersonNotFoundException();
        }
    }

    @Override
    public Flux<Person> getPersonByName(String name) {

        Flux<Person> personList = personRepository.findByName(name);

        if (ObjectUtils.isNotEmpty(personList)){
            return personList;
        } else {
            throw new PersonNotFoundException();
        }
    }

}
