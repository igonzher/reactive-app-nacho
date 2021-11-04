package com.nacho.app.controller;

import com.nacho.app.controller.mapper.PersonMapperControllerImpl;
import com.nacho.app.model.Person;
import com.nacho.app.service.person.PersonServiceImpl;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PersonControllerTest {

    @Mock
    PersonServiceImpl personService;

    @Mock
    PersonMapperControllerImpl personMapperController;

    @InjectMocks
    PersonController personController;

    private Person person;
    private model.Person persoApi;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new Person();
        person.setDni("74548912D");
        person.setName("Nacho Gonzalez");
        person.setAge(30);

        persoApi = new model.Person();
        persoApi.setDni("74548912D");
        persoApi.setName("Adrian Gonzalez");
        persoApi.setAge(20);
    }

  /*  @Test
    public void getPeople() {
        when(personService.getPeople()).thenReturn(Arrays.asList(person));
        when(personMapperController.peopleToPeopleApi(Arrays.asList(person))).thenReturn(Arrays.asList(persoApi));

        ResponseEntity<List<model.Person>> people = personController.getPeople();
        verify(personService).getPeople();
        verify(personMapperController).peopleToPeopleApi(Arrays.asList(person));
        assertNotNull(people);
    }

    @Test
    public void createPeople() {
        when(personMapperController.personApiToPerson(persoApi)).thenReturn(person);
        when(personService.createPerson(person)).thenReturn(person);
        when(personService.getPeople()).thenReturn(Arrays.asList(person));
        when(personMapperController.peopleToPeopleApi(Arrays.asList(person))).thenReturn(Arrays.asList(persoApi));

        ResponseEntity<List<model.Person>> people = personController.createPeople(persoApi);
        verify(personMapperController).personApiToPerson(persoApi);
        verify(personService).createPerson(person);
        verify(personService).getPeople();
        verify(personMapperController).peopleToPeopleApi(Arrays.asList(person));
        assertNotNull(people);
    }

    @Test
    public void updatePeople() {
        when(personMapperController.personApiToPerson(persoApi)).thenReturn(person);
        //when(personService.createPerson(person)).thenReturn(person);
        when(personService.getPeople()).thenReturn(Arrays.asList(person));
        when(personMapperController.peopleToPeopleApi(Arrays.asList(person))).thenReturn(Arrays.asList(persoApi));

        ResponseEntity<List<model.Person>> people = personController.updatePeople(persoApi);
        verify(personMapperController).personApiToPerson(persoApi);
        verify(personService).updatePerson(person);
        verify(personService).getPeople();
        verify(personMapperController).peopleToPeopleApi(Arrays.asList(person));
        assertNotNull(people);
    }

    @Test
    public void deletePeople() {
        //when(personService.deletePerson(person.getDni())).thenReturn(person);

        ResponseEntity<Void> result = personController.deletePeople(person.getDni());
        verify(personService).deletePerson(person.getDni());
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }*/
}