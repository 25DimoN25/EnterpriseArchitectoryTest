package archlab;

import archlab.entity.Discipline;
import archlab.entity.Mark;
import archlab.entity.Student;
import archlab.entity.Teacher;
import archlab.repository.DisciplinesDao;
import archlab.repository.MarksDao;
import archlab.repository.StudentsDao;
import archlab.repository.TeachersDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

@DataJpaTest(showSql = false)
@RunWith(SpringJUnit4ClassRunner.class)
public class MarksDaoTest {

	@Autowired
	MarksDao marksDao;

	@Autowired
	StudentsDao studentsDao;

	@Autowired
	DisciplinesDao disciplinesDao;


	@Test
	public void findByStudentTest() {
		Student student = studentsDao.findByLastNameIgnoreCase("соколова").get(0);
		List<Mark> marks = marksDao.findByStudent(student);
		for (Mark mark : marks) {
			System.out.println(mark);
		}
	}

	@Test
	public void findByDiscipline() {
//		Discipline discipline = disciplinesDao.findByNameIgnoreCaseContains("Теоретическая механика").get(0);
//		List<Mark> marks = marksDao.findByDiscipline(discipline);
//		for (Mark mark : marks) {
//			System.out.println(mark);
//		}
	}

	@Test
	public void findByStudentAndDiscipline() {
//		Student student = studentsDao.findByLastNameIgnoreCase("Макаров").get(0);
//		Discipline discipline = disciplinesDao.findByNameIgnoreCaseContains("Теоретическая механика").get(0);
//
//		System.out.println(student);
//		System.out.println(discipline);
//
//		List<Mark> marks = marksDao.findByStudentAndDiscipline(student, discipline);
//		for (Mark mark : marks) {
//			System.out.println(mark);
//		}
//
//		Assert.assertTrue(marks.size() > 0);
	}

	@Test
	public void findByMarkAndMarkTimeBetween() {
		List<Mark> markList = marksDao.findByMarkAndMarkTimeBetween(5, Date.valueOf("2014-01-01"), Date.valueOf("2015-01-01"));
		for (Mark mark : markList) {
			System.out.println(mark);
		}

	}

}