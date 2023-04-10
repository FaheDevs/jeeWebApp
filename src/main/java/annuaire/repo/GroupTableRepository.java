package annuaire.repo;

import annuaire.model.GroupTable;
import org.springframework.data.repository.CrudRepository;

public interface GroupTableRepository extends CrudRepository<GroupTable,Long> {

    GroupTable findGroupByName(String name );



}
