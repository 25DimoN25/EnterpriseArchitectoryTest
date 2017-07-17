package archlab;

import archlab.entity.Speciality;
import archlab.repository.SpecialitiesDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest(showSql = false)
public class SpecialitiesDaoTest {

	@Autowired
	private SpecialitiesDao specialitiesDao;

	@Test
	public void test() {
		List<Speciality> specialities = specialitiesDao.findByNameIgnoreCaseContains("автоматизация технологических");
		for (Speciality speciality : specialities) {
			System.out.println(speciality);
		}
	}
}