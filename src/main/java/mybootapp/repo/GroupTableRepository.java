package mybootapp.repo;

import mybootapp.model.GroupTable;
import mybootapp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GroupTableRepository extends CrudRepository<GroupTable,Long> {

    GroupTable findGroupByName(String name );
    List<Person> findByPersonListbyid(Long id );

}
