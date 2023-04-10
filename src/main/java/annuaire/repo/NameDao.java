package annuaire.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class NameDao {


    private static final String DB_URL = "jdbc:hsqldb:file:database/finalDb";
    private static final String USER = "user";
    private static final String PASSWORD = "user";
    @Value("${spring.datasource.url}")
    private String test;


    private Connection newConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    @PostConstruct
    public void initSchema() throws SQLException {
        var query = "create table if not exists NAME (" //
                + " id integer not null, " //
                + " name varchar(50) not null, " //
                + " primary key (id) )";
        try (var conn = newConnection()) {
            conn.createStatement().execute(query);
        }
    }

    public void addName(int id, String name) throws SQLException {
        var query = "insert into NAME values (?,?)";
        try (var conn = newConnection()) {
            var st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.setString(2, name);
            st.execute();
        }
    }

    public void deleteName(int id) throws SQLException {
        var query = "Delete From NAME where (id = ?)";
        try (var conn = newConnection()) {
            var st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.execute();
        }
    }

    public String findName(int id) throws SQLException {
        var query = "Select * From NAME where (id = ?)";
        try (var conn = newConnection()) {
            var st = conn.prepareStatement(query);
            st.setInt(1, id);
            var rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        }
        return null;
    }

    public Collection<String> findNames() throws SQLException {
        var query = "Select * From NAME order by name";
        var result = new LinkedList<String>();
        try (var conn = newConnection()) {
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
        }
        return result;
    }

    public void updateName(int id, String newName) throws SQLException {
        var query = "update NAME set name = ? where id = ?";
        try (var conn = newConnection()) {
            var st = conn.prepareStatement(query);
            st.setString(1, newName);
            st.setInt(2, id);
            st.execute();
        }
    }

    public void dropSchema() {
    }
}