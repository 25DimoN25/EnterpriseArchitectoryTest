package archlab.repository;

import archlab.entity.Discipline;
import archlab.entity.Faculty;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultiesDao extends CrudRepository<Faculty, Long> {
	List<Faculty> findByNameIgnoreCaseContains(String name);
}
