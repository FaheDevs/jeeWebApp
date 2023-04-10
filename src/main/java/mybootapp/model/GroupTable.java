package mybootapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity


@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
public class GroupTable {

    @Id()
    private Long id;
    @Column(nullable = false)
    private String  name ;


    @OneToMany(mappedBy = "group",fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<Person> personListbyid ;


}