package archlab;

import archlab.entity.Post;
import archlab.entity.Teacher;
import archlab.repository.TeachersDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest(showSql = false)
public class TeacherDaoTest {

	@Autowired
	TeachersDao teachersDao;

	@Test
	public void testTeacherDaoFindByName() {
		Teacher teacher = teachersDao.findByName("Иван", "Рыжов");
		System.out.println(teacher);
	}

	@Test
	public void testTeacherDaoFindByNameAndPost() {
		List<Teacher> teachers = teachersDao.findByPost(Post.HIGHT_TEACHER);
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}


}
