package annuaire.repo;

import annuaire.model.GroupTable;
import annuaire.model.Person;
import annuaire.web.Starter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = {Starter.class, GroupTable.class, Person.class})

public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GroupTableRepository groupRepository;

    private Person testPerson;
    private GroupTable groupTable;

    @BeforeEach
    public void setUp() {
        groupTable = new GroupTable(1L,"GROUPE 1",new ArrayList<>());
        groupRepository.save(groupTable);
        testPerson = new Person();
        testPerson.setFirstName("John");
        testPerson.setLastName("Doe");
        testPerson.setEmail("john.doe@example.com");
        testPerson.setPassword("password123");
        testPerson.setGroup(groupTable);
        personRepository.save(testPerson);
    }

    @Test
    public void testFindByEmail() {

        System.err.println(personRepository.findAll());
        String email = "john.doe@example.com";


        Person result = personRepository.findByEmail(email);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(testPerson.getId(), result.getId());
        Assertions.assertEquals(testPerson.getEmail(), result.getEmail());
    }

    @Test
    public void testFindByFirstNameAndLastName() {
        String firstName = "John";
        String lastName = "Doe";
        List<Person> results = personRepository.findByFirstNameAndLastName(firstName, lastName);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(testPerson.getId(), results.get(0).getId());
        Assertions.assertEquals(testPerson.getFirstName(), results.get(0).getFirstName());
        Assertions.assertEquals(testPerson.getLastName(), results.get(0).getLastName());
    }

    @Test
    public void testFindAllByGroupId() {
        List<Person> results = personRepository.findAllByGroupId(groupTable.getId());
        Assertions.assertNotNull(results);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(testPerson.getId(), results.get(0).getId());
        Assertions.assertEquals(testPerson.getGroup().getId(), results.get(0).getGroup().getId());
    }

    @Test
    public void testSavePerson() {
        Person newPerson = new Person();
        newPerson.setFirstName("Jane");
        newPerson.setLastName("Doe");
        newPerson.setEmail("jane.doe@example.com");
        newPerson.setPassword("password456");
        Person savedPerson = personRepository.save(newPerson);
        Assertions.assertNotNull(savedPerson);
        Assertions.assertNotNull(savedPerson.getId());
        Assertions.assertEquals(newPerson.getFirstName(), savedPerson.getFirstName());
        Assertions.assertEquals(newPerson.getLastName(), savedPerson.getLastName());
        Assertions.assertEquals(newPerson.getEmail(), savedPerson.getEmail());
        Assertions.assertEquals(newPerson.getPassword(), savedPerson.getPassword());
    }

    @Test
    public void testDeletePerson() {
        Long id = testPerson.getId();
        personRepository.deleteById(id);
        Assertions.assertFalse(personRepository.existsById(id));
    }


}

