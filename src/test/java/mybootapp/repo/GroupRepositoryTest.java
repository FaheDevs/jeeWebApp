package mybootapp.repo;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.web.Starter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)

class GroupRepositoryTest {


    @Autowired
    GroupRepository groupRepository ;

    private Group testGroup;



        testGroup = new Group(2L, "Test Group", null);
        groupRepository.save(testGroup);


    @Test
    void findGroupById() {
        Optional<Group> groupOptional = groupRepository.findById(testGroup.getId());
        assertNotNull(groupOptional);
        assertEquals(testGroup.getName(), groupOptional.get().getName());
    }

    @Test
    void findGroupByName() {
        Group group = groupRepository.findGroupByName(testGroup.getName());
        assertNotNull(group);
        assertEquals(testGroup.getId(), group.getId());
    }

    @Test
    void findByPersonListbyid() {
        List<Person> personList = groupRepository.findByPersonListbyid(testGroup.getId());
        assertNotNull(personList);
        assertEquals(0, personList.size());
    }
}