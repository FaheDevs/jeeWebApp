package mybootapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity


@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor

public class Person {


    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
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