package mybootapp.repo;

import mybootapp.model.GroupTable;
import mybootapp.model.Person;
import mybootapp.web.Starter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)

class GroupRepositoryTest {


    @Autowired
    GroupTableRepository groupRepository ;

    private GroupTable testGroup;

    @BeforeEach
    void setup(){
        testGroup = new GroupTable(2L, "Test Group", new ArrayList<>());
        groupRepository.save(testGroup);
    }



    @Test
    void findGroupById() {

        System.out.println(groupRepository.findAll());

        var groupTable = groupRepository.findById(testGroup.getId());
        groupTable.ifPresent(table -> assertEquals(table.getId(), testGroup.getId()));

    }

    @Test
    void findGroupByName() {
        var result = groupRepository.findGroupByName(testGroup.getName());
        assertNotNull(result);
        assertEquals(testGroup.getName(), result.getName());
    }

    @Disabled
    void findByPersonListbyid() {
        List<Person> personList = groupRepository.findByPersonListbyid(testGroup.getId());
        assertNotNull(personList);
        assertEquals(0, personList.size());
    }
}