package archlab.repository;

import archlab.entity.Discipline;
import archlab.entity.Mark;
import archlab.entity.Student;
import archlab.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface MarksDao extends CrudRepository<Mark, Long> {
	public List<Mark> findByStudent(Student student);

	public List<Mark> findByDiscipline(Discipline discipline);

	public List<Mark> findByStudentAndDiscipline(Student student, Discipline discipline);

	public List<Mark> findByMarkAndMarkTimeBetween(int mark, Date date1, Date date2);

}
