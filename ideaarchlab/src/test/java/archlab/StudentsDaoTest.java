package archlab;

import archlab.entity.Group;
import archlab.entity.GroupType;
import archlab.entity.Mark;
import archlab.entity.Student;
import archlab.repository.GroupsDao;
import archlab.repository.MarksDao;
import archlab.repository.SpecialitiesDao;
import archlab.repository.StudentsDao;
import archlab.services.StudentService;
import archlab.services.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest(showSql = false)
public class StudentsDaoTest {

	@Autowired
	private StudentsDao studentsDao;

	@Autowired
	private GroupsDao groupsDao;

	@Test
	public void testFindByName() {
		Student student = studentsDao.findByName("Арсений", "Кудрявцев");
		System.out.println(student);
	}

	@Test
	public void testFindByLastName() {
		for (Student student : studentsDao.findByLastNameIgnoreCase("Белякова")) {
			System.out.println(student);
		}
	}

	@Test
	public void testFindByAdmission() {
		for (Student student : studentsDao.findByAdmissionBetween(Date.valueOf("2008-06-01"), Date.valueOf("2008-08-01"))) {
			System.out.println(student);
		}

	}

	@Test
	public void testFindByGroup() {
		Group group = groupsDao.findOne(10L);
		for (Student student : studentsDao.findByGroups(group)) {
			System.out.println(student);
		}
	}

}
