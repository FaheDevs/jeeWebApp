package mybootapp.repo;

import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
public interface PersonRepository extends CrudRepository<Person, Long> {

    // Recherche par adresse e-mail
    Person findByEmail(String email);

    // Recherche par nom de famille
    List<Person> findByLastName(String lastName);

    // Recherche par groupe
    List<Person> findByGroup(Group group);

    // Recherche par date de naissance après une certaine date
    List<Person> findByDateOfBirthAfter(Date date);

    // Recherche par mot de passe
    Person findByPassword(String password);

    // Recherche par nom et prénom
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    // Recherche par nom et groupe
    List<Person> findByLastNameAndGroup(String lastName, Group group);

    // Recherche par nom de famille ordonnée par date de naissance décroissante
    List<Person> findByLastNameOrderByDateOfBirthDesc(String lastName);

    List<Person> findAllByGroupId(Long id);

    void deleteById(Long aLong);
}





