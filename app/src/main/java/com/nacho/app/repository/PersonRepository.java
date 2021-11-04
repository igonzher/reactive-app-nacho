package com.nacho.app.repository;

import com.nacho.app.model.Person;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonRepository extends ReactiveMongoRepository<Person, Long> {

    Mono<Person> findById(String id);
    Mono<Person> findByDni(String dni);
    Flux<Person> findByName(String name);
    List<Person> findByAge(int age);

    @DeleteQuery
    void  deleteByDni(String dni);

}
