package annuaire.repo;

import annuaire.model.GroupTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GroupDao implements IGroupDao{


    @Autowired
    GroupTableRepository groupTableRepository;

    @Override
    public Optional<GroupTable> findById(Long id) {
        return groupTableRepository.findById(id);
    }

    @Override
    public List<GroupTable> findAll() {
        return (List<GroupTable>) groupTableRepository.findAll();
    }

    @Override
    public GroupTable save(GroupTable groupTable) {
        return groupTableRepository.save(groupTable);
    }

    @Override
    public void delete(GroupTable groupTable) {
        groupTableRepository.delete(groupTable);
    }

    @Override
    public void update(GroupTable groupTable) {
        groupTableRepository.save(groupTable);
    }

    @Override
    public GroupTable findGroupByName(String name) {
        return groupTableRepository.findGroupByName(name);
    }
}
