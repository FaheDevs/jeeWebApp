package annuaire.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import annuaire.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findByName(String name);

	List<Course> findByNameLike(String name);

}
