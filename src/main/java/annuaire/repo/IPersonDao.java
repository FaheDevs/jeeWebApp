package annuaire.repo;

import annuaire.model.GroupTable;
import annuaire.model.Person;

import java.util.Date;
import java.util.List;

public interface IPersonDao {

    Person findByEmail(String email);

    List<Person> findByLastName(String lastName);

    List<Person> findByGroup(GroupTable group);

    List<Person> findByDateOfBirthAfter(Date date);

    Person findByPassword(String password);

    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findByLastNameAndGroup(String lastName, GroupTable group);

    List<Person> findByLastNameOrderByDateOfBirthDesc(String lastName);

    List<Person> findAllByGroupId(Long id);

    void deleteById(Long aLong);

    Person save(Person person);

    List<Person> findAll();

}
