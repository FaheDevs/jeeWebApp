package mybootapp.repo;

import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group,Long> {

    Group findGroupById(Long id );
    Group findGroupByName(String name );
    List<Person> findByPersonListbyid(Long id );
}
