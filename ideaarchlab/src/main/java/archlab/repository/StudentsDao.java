package archlab.repository;

import archlab.entity.Group;
import archlab.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface StudentsDao extends CrudRepository<Student, Long> {

	@Query("SELECT s FROM Students s WHERE LOWER(firstName) = LOWER(?1) AND LOWER(lastName) = LOWER(?2)")
	Student findByName(String firstName, String lastName);

	List<Student> findByLastNameIgnoreCase(String lastName);

	List<Student> findByAdmissionBetween(Date date1, Date date2);

	@Query("SELECT DISTINCT s FROM Students s INNER JOIN s.groups g WHERE g IN ?1")
	List<Student> findByGroups(Group ... groups);

	@Query("SELECT s FROM Students s WHERE s.expulsion = NULL")
	List<Student> findAllStudying();
}
