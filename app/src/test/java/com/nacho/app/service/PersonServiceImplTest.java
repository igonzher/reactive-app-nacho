package com.nacho.app.service;

import com.nacho.app.model.Person;
import com.nacho.app.repository.PersonRepository;
import com.nacho.app.repository.mapper.PersonMapperImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @Mock
    PersonMapperImpl personMapper;

    @InjectMocks
    PersonServiceImpl personService;

    private Person person;
    private Person personToUpdate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        //this.personMapper = mock(PersonMapper.class);

        person = new Person();
        person.setDni("74548912D");
        person.setName("Nacho Gonzalez");
        person.setAge(30);

        personToUpdate = new Person();
        personToUpdate.setDni("74548912D");
        personToUpdate.setName("Adrian Gonzalez");
        personToUpdate.setAge(20);
    }

    /*@Test
    public void createPerson() {
        when(personRepository.findByDni(person.getDni())+"1").thenReturn(null);
        when(personRepository.insert(person)).thenReturn(person);

        person.setDni(person.getDni()+"1");
        personService.createPerson(person);
        verify(personRepository).findByDni((person.getDni()));
        verify(personRepository).insert(person);
    }

    @Test(expected = PersonDniDuplicateException.class)
    public void createPersonException() {
        when(personRepository.findByDni(person.getDni())).thenReturn(personToUpdate);

        personService.createPerson(person);
        verify(personRepository).findByDni((person.getDni()));
        verifyNoInteractions(personRepository.insert(person));
    }

    @Test
    public void updatePerson() {
        when(personRepository.findByDni(person.getDni())).thenReturn(personToUpdate);
        when(personMapper.personToPerson(personToUpdate, person)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(person);

        personService.updatePerson(person);
        verify(personRepository).findByDni(person.getDni());
        verify(personMapper).personToPerson(personToUpdate, person);
        verify(personRepository).save(person);
    }

    @Test(expected = PersonNotFoundException.class)
    public void updatePersonException() {
        when(personRepository.findByDni(person.getDni()+"1")).thenReturn(personToUpdate);

        personService.updatePerson(person);
        verify(personRepository).findByDni((person.getDni()+"1"));
        verifyNoInteractions(personRepository.save(person));
    }

    @Test
    public void deletePerson() {
        personService.deletePerson(person.getDni());
        verify(personRepository).deleteByDni(person.getDni());
    }

    @Test
    public void getPeople() {
        when(personRepository.findAll()).thenReturn(Arrays.asList(person));

        List<Person> personList = personService.getPeople();
        assertNotNull(personList);
        assertEquals(Arrays.asList(person), personList);
    }
*/
}