package archlab;

import archlab.entity.Group;
import archlab.entity.GroupType;
import archlab.entity.Speciality;
import archlab.entity.Student;
import archlab.repository.GroupsDao;
import archlab.repository.SpecialitiesDao;
import archlab.repository.StudentsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest(showSql = false)
public class GroupsDaoTest {

	@Autowired
	private GroupsDao groupsDao;

	@Autowired
	private StudentsDao studentsDao;

	@Autowired
	private SpecialitiesDao specialitiesDao;

	@Test
	public void testFindByData() {
		Speciality speciality = specialitiesDao.findByNameIgnoreCaseContains("Автоматизация технологических процессов и производств").get(0);
		List<Group> groups = groupsDao.findByAllData(1, speciality, GroupType.MASTER, true);
		for (Group group : groups) {
			System.out.println(group);
		}
	}

	@Test
	public void testFindByCourse() {
		List<Group> groups = groupsDao.findByCourse(5);
		for (Group group : groups) {
			System.out.println(group);
		}
	}

	@Test
	public void testFindBySpecialityAndCreationDateBetween() {
		Speciality speciality = specialitiesDao.findByNameIgnoreCaseContains("Автоматизация технологических процессов и производств").get(0);
		List<Group> groups = groupsDao.findBySpecialityAndCreationDateBetween(speciality, Date.valueOf("2003-09-01"), Date.valueOf("2003-10-1"));

		for (Group group : groups) {
			System.out.println(group);
		}
	}


	@Test
	public void testFindByStudents() {
		Student student1 = studentsDao.findByName("Акулина", "Куликова");
		Student student2 = studentsDao.findByName("Пётр", "Овчинников");
		for (Group group : groupsDao.findByStudents(student1, student2)) {
			System.out.println(group);
		}
	}
}
