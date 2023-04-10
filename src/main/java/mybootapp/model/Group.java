package mybootapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity


@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
public class Group {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String  name ;


    @OneToMany(mappedBy = "group")
    private List<Person> personListbyid ;


}