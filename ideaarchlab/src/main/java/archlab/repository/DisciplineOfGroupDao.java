package archlab.repository;


import archlab.entity.Discipline;
import archlab.entity.DisciplineOfGroup;
import archlab.entity.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplineOfGroupDao extends CrudRepository<DisciplineOfGroup, Long> {
	List<DisciplineOfGroup> findByDiscipline(Discipline discipline);

	List<DisciplineOfGroup> findByGroup(Group group);
}
