package annuaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@Data // Generates getters, setters, toString(), equals(), and hashCode()
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor

public class Person implements Serializable {



    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String firstName;
    @Column()
    private String lastName;
    @Basic(optional = false)
    @Column(nullable = false, unique = true)
    private String email;
    @Column()
    private String website;
    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = true)
    @JoinColumn(name = "group_ref")
    private GroupTable group;







}