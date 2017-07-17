package archlab.services;

import archlab.entity.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface MarksService {

	void newMark(Student student, String discipline, int mark, Teacher teacher, Date date);

	List<Mark> getAllMarksOfStudent(Student student);

	List<Mark> getAllMarksOfGroup(Group group);

	Mark getMarkOfStudentByDiscipline(Student student, Discipline discipline);
}
