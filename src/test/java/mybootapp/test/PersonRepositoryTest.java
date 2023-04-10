package mybootapp.test;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.web.Starter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)

public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GroupRepository groupRepository;

    private Person testPerson;

    @BeforeEach
    public void setUp() {
        testPerson = new Person();
        testPerson.setFirstName("John");
        testPerson.setLastName("Doe");
        testPerson.setEmail("john.doe@example.com");
        testPerson.setPassword("password123");
        personRepository.save(testPerson);
    }

    @Test
    public void testFindByEmail() {
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
        Group testGroup = new Group();
        testGroup.setName("Test Group");
        testGroup = groupRepository.save(testGroup);
        testPerson.setGroup(testGroup);
        personRepository.save(testPerson);
        List<Person> results = personRepository.findAllByGroupId(testGroup.getId());
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

