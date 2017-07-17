package archlab.services;

import archlab.entity.Post;
import archlab.entity.Teacher;


public interface TeacherService {

	void newTeacher(String name, String surname, Post post);

	Teacher getTeacher(String name, String surname);

	void dismissTeacher(String name, String surname);

}
