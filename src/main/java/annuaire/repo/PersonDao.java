package annuaire.repo;

import annuaire.model.GroupTable;
import annuaire.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;




public class PersonDao implements IPersonDao {

    @Autowired
    private PersonRepository personRepository;

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public List<Person> findByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public List<Person> findByGroup(GroupTable group) {
        return personRepository.findByGroup(group);
    }

    public List<Person> findByDateOfBirthAfter(Date date) {
        return personRepository.findByDateOfBirthAfter(date);
    }

    public Person findByPassword(String password) {
        return personRepository.findByPassword(password);
    }

    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Person> findByLastNameAndGroup(String lastName, GroupTable group) {
        return personRepository.findByLastNameAndGroup(lastName, group);
    }

    public List<Person> findByLastNameOrderByDateOfBirthDesc(String lastName) {
        return personRepository.findByLastNameOrderByDateOfBirthDesc(lastName);
    }

    public List<Person> findAllByGroupId(Long id) {
        return personRepository.findAllByGroupId(id);
    }

    public void deleteById(Long aLong) {
        personRepository.deleteById(aLong);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

}
