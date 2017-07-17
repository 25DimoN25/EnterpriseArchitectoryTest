package archlab.repository;

import archlab.entity.Group;
import archlab.entity.GroupType;
import archlab.entity.Speciality;
import archlab.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface GroupsDao extends CrudRepository<Group, Long> {

	@Query("SELECT g FROM Groups g WHERE course = ?1 AND speciality = ?2 AND type = ?3 AND fulltime = ?4")
	List<Group> findByAllData(int course, Speciality speciality, GroupType type, boolean fulltime);

	List<Group> findByCourse(int course);

	List<Group> findBySpecialityAndCreationDateBetween(Speciality speciality, Date date1, Date date2);

	@Query("SELECT DISTINCT g FROM Groups g INNER JOIN g.students s WHERE s IN ?1")
	List<Group> findByStudents(Student... students);
}
