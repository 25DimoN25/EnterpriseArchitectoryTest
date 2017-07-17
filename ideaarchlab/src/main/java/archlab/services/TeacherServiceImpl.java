package archlab.services;

import archlab.entity.Post;
import archlab.entity.Teacher;
import archlab.repository.TeachersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeachersDao teachersDao;

	@Override
	public void newTeacher(String name, String surname, Post post) {
		Teacher teacher = new Teacher(name, surname, post);
		teachersDao.save(teacher);
	}

	@Override
	public Teacher getTeacher(String name, String surname) {
		return teachersDao.findByName(name, surname);
	}

	@Override
	public void dismissTeacher(String name, String surname) {
		Teacher teacher = teachersDao.findByName(name, surname);
		if (teacher != null)
			teachersDao.delete(teacher.getId());
	}
}
