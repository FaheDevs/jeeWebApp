package annuaire.repo;


import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = NameDao.class)

public class NameDaoTest {

    @Autowired
    NameDao dao;

    @Test
    public void testNames() throws SQLException {
        dao.deleteName(100);
        dao.deleteName(200);
        dao.addName(100, "Hello");
        dao.addName(200, "Salut");
        assertEquals("Hello", dao.findName(100));
        assertEquals("Salut", dao.findName(200));
        dao.findNames().forEach(System.out::println);
    }

    @Test
    public void testErrors() throws SQLException {
        dao.deleteName(300);
        assertThrows(SQLException.class, () -> {
            dao.addName(300, "Bye");
            dao.addName(300, "Au revoir");
        });
        assertEquals("Bye", dao.findName(300));
    }


    @Test
    public void testUpdateName() throws SQLException {
        dao.deleteName(400);
        dao.addName(400, "Hello");
        dao.updateName(400, "Hola");
        assertEquals("Hola", dao.findName(400));
    }

    @Test
    public void testGetAllNames() throws SQLException{
        System.out.println(dao.findNames());
    }

    @AfterEach
    void tearDown() throws SQLException {
        dao.dropSchema();
    }



}