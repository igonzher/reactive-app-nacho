package com.nacho.app.service.person;

import com.nacho.app.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    //CRUD
    Mono<Person> createPerson(Person person);
    Mono<Person> updatePerson(Person person);
    Mono<Void> deletePerson(Person person);
    Flux<Person> getPeople();

    Mono<Person> getPersonByDni(String dni);
    Flux<Person> getPersonByName(String name);

    //Mono<Person> CheckPersonCreateByDni(String dni);
}
