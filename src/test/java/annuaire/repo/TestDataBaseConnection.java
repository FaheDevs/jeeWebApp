package annuaire.repo;


import annuaire.model.GroupTable;
import annuaire.model.Person;
import annuaire.web.Starter;
import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {Starter.class, GroupTable.class, Person.class})
public class TestDataBaseConnection {


    private static final String DB_URL = "jdbc:hsqldb:file:database/finalDb";
    private static final String USER = "user";
    private static final String PASSWORD = "user";

    @Test
    public void testConnection() throws SQLException {
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setURL(DB_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        try (Connection connection = dataSource.getConnection()) {
            assertNotNull(connection);
        }
        String sql = "CREATE TABLE personnes (id INT NOT NULL, nom VARCHAR(50), age INT, PRIMARY KEY (id))";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }

    }



}
