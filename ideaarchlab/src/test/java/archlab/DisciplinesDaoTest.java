package archlab;

import archlab.entity.Discipline;
import archlab.entity.Speciality;
import archlab.repository.DisciplinesDao;
import archlab.repository.SpecialitiesDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest(showSql = false)
public class DisciplinesDaoTest {

	@Autowired
	private DisciplinesDao disciplinesDao;

	@Test
	public void test() {
		List<Discipline> disciplines = disciplinesDao.findByNameIgnoreCaseContains("механика");
		for (Discipline discipline : disciplines) {
			System.out.println(discipline);
		}

	}
}