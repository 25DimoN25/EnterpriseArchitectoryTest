package archlab.services;

import archlab.entity.Group;
import archlab.entity.Mark;
import archlab.entity.Student;
import archlab.repository.StudentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service @Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentsDao studentsDao;

	@Override
	public void newStudent(String name, String surname) {
		Student student = new Student();
		student.setFirstName(name);
		student.setLastName(surname);
		student.setAdmission(Date.valueOf(LocalDate.now()));
		studentsDao.save(student);
	}

	@Override
	public Student getStudent(String name, String surname) {
		return studentsDao.findByName(name, surname);
	}

	@Override
	public List<Student> getStudentsByGroups(Group... groups) {
		return studentsDao.findByGroups(groups).stream()
				.collect(Collectors.groupingBy(s -> s.getExpulsion() == null))
				.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
				.peek(entry -> entry.getValue()
								.sort(Comparator.comparing(Student::getLastName)
											.thenComparing(Student::getFirstName)))
				.map(entry -> entry.getValue())
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithAvgMarkMoreThan(double avgMark, int semesterOffset) { //TODO нужны тесты
		LocalDate targetDate = LocalDate.now().minusMonths(6 * semesterOffset);

		int currentMonth = targetDate.getMonth().getValue();
		int currentYear = targetDate.getYear();

		final Date semesterStart, semesterEnd;
		if (currentMonth >= 9 && currentMonth <= 12) {
			semesterStart = Date.valueOf(LocalDate.of(currentYear, 5, 1));
			semesterEnd = Date.valueOf(LocalDate.of(currentYear, 9, 1));
		} else if (currentMonth == 1 || currentMonth == 2) {
			semesterStart = Date.valueOf(LocalDate.of(currentYear - 1, 5, 1));
			semesterEnd = Date.valueOf(LocalDate.of(currentYear - 1, 9, 1));
		} else if (currentMonth > 2 && currentMonth < 9) {
			semesterStart = Date.valueOf(LocalDate.of(currentYear - 1, 12, 1));
			semesterEnd = Date.valueOf(LocalDate.of(currentYear, 3, 1));
		} else {
			semesterStart = semesterEnd = null;
		}

		return studentsDao.findAllStudying().stream()
				.filter(student -> student.getMarks() != null && student.getMarks().size() > 0)	// оставляем студентов с оценками
				.filter(student -> student.getMarks().stream()	//оставляем студентов с оценками в нужном семестре
						.filter(mark -> mark.getMarkTime().compareTo(semesterStart) >= 0
								&& mark.getMarkTime().compareTo(semesterEnd) <= 0)
						.count() > 0)
				.filter(student -> student.getMarks().stream()	//оставляем студентов с оценками больше нужной в нужном семестре
						.filter(mark -> mark.getMarkTime().compareTo(semesterStart) >= 0
								&& mark.getMarkTime().compareTo(semesterEnd) <= 0)
						.mapToInt(Mark::getMark)
						.average()
						.getAsDouble() >= avgMark)
				.collect(Collectors.toList());

	}

	@Override
	public Student getStudentById(long id) {
		return studentsDao.findOne(id);
	}
}
