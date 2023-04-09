package mybootapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Person")


@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor

public class Person {


    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic()
    private String firstName;
    @Basic()
    private String lastName;

    @Basic(optional = false)
    private String email;
    @Basic()
    private String website;
    @Basic()
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Basic(optional = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;







}