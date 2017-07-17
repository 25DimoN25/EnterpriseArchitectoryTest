package archlab.services;

import archlab.entity.*;
import archlab.repository.DisciplinesDao;
import archlab.repository.MarksDao;
import archlab.repository.StudentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service @Transactional
public class MarksServiceImpl implements MarksService {
	@Autowired
	MarksDao marksDao;

	@Autowired
	StudentsDao studentsDao;

	@Autowired
	DisciplinesDao disciplinesDao;

	@Override
	public void newMark(Student student, String discipline, int mark, Teacher teacher, Date date) {
		Discipline disc = disciplinesDao.findByNameIgnoreCaseContains(discipline).get(0); // TODO

		Mark newMark = new Mark(Date.valueOf(LocalDate.now()), mark, disc, teacher, student);
		marksDao.save(newMark);
	}

	@Override
	public List<Mark> getAllMarksOfStudent(Student student) {
		return marksDao.findByStudent(student);
	}

	@Override
	public List<Mark> getAllMarksOfGroup(Group group) {

		return studentsDao.findByGroups(group).stream()
				.flatMap(s -> s.getMarks().stream())
				.collect(Collectors.toList());
	}

	@Override
	public Mark getMarkOfStudentByDiscipline(Student student, Discipline discipline) {
		return student.getMarks().stream()
				.filter(mark -> mark.getDiscipline().equals(discipline))
				.max(Comparator.comparing(Mark::getMarkTime))
				.get();

	}
}
