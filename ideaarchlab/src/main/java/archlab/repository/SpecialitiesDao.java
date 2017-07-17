package archlab.repository;

import archlab.entity.Faculty;
import archlab.entity.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SpecialitiesDao extends CrudRepository<Speciality, Long> {
	List<Speciality> findByNameIgnoreCaseContains(String name);

	List<Speciality> findByFaculty(Faculty faculty);
}
