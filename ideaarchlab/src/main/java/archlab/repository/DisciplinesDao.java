package archlab.repository;

import archlab.entity.Discipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplinesDao extends CrudRepository<Discipline, Long> {
	List<Discipline> findByNameIgnoreCaseContains(String name);
}
