package annuaire.repo;

import annuaire.model.GroupTable;

import java.util.List;
import java.util.Optional;

public interface IGroupDao {

    Optional<GroupTable> findById(Long id);

    List<GroupTable> findAll();

    GroupTable save(GroupTable groupTable);

    void delete(GroupTable groupTable);

    void update(GroupTable groupTable);

    GroupTable findGroupByName(String name);
}
