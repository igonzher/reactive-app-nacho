package com.nacho.app.controller;


import api.PeopleApi;
import com.nacho.app.controller.mapper.PersonMapperControllerImpl;
import com.nacho.app.model.useCase.person.*;
import com.nacho.app.service.person.PersonServiceImpl;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController implements PeopleApi {

    private final PersonServiceImpl personService;
    PersonMapperControllerImpl personMapperController;

    GetPeopleUseCase getPeopleUSeCase;
    GetPersonByDniUseCase getPersonByDniUseCase;
    GetPeopleByNameUseCase getPeopleByNameUseCase;
    CreatePersonUseCase createPersonUseCase;
    UpdatePersonUseCase updatePersonUseCase;
    DeletePersonUseCase deletePersonUseCase;

    @Autowired
    public PersonController(
            PersonServiceImpl personService, PersonMapperControllerImpl personMapperController,
            GetPeopleUseCase getPeopleUSeCase, GetPersonByDniUseCase getPersonByDniUseCase,
            GetPeopleByNameUseCase getPeopleByNameUseCase, CreatePersonUseCase createPersonUseCase,
            UpdatePersonUseCase updatePersonUseCase, DeletePersonUseCase deletePersonUseCase
    ) {
        this.personService = personService;
        this.personMapperController = personMapperController;

        this.getPeopleUSeCase = getPeopleUSeCase;
        this.getPersonByDniUseCase = getPersonByDniUseCase;
        this.getPeopleByNameUseCase = getPeopleByNameUseCase;
        this.createPersonUseCase = createPersonUseCase;
        this.updatePersonUseCase = updatePersonUseCase;
        this.deletePersonUseCase = deletePersonUseCase;
    }

    @Override
    public ResponseEntity<List<Person>> getPeople() {
        List<Person> responseEntity = getPeopleUSeCase.dispacth().block();
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @Override
    public  ResponseEntity<Person> getPersonByDni(@PathVariable("dni") String dni){
        Person responseEntity = getPersonByDniUseCase.dispacth(dni).block();
        return new ResponseEntity<>(responseEntity, HttpStatus.FOUND);
    }

    @Override
    public  ResponseEntity<List<Person>> getPersonByName(@PathVariable("name") String name){
        List<Person> responseEntity = getPeopleByNameUseCase.dispacth(name).block();
        return new ResponseEntity<>(responseEntity, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<model.Person> createPeople(@RequestBody model.Person person) {
        com.nacho.app.model.Person personToCreate = personMapperController.personApiToPerson(person);
        Person personCreated =  createPersonUseCase.dispacth(personToCreate).block();
        return new ResponseEntity<>(personCreated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<model.Person> updatePeople(@RequestBody model.Person person) {
        com.nacho.app.model.Person personToUpdate = personMapperController.personApiToPerson(person);
        Person personUpdated = updatePersonUseCase.dispacth(personToUpdate).block();
        return new ResponseEntity<>(personUpdated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deletePeople(@PathVariable("DNI") String DNI) {
       deletePersonUseCase.dispacth(DNI).block();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
