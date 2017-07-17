package archlab.services;

import archlab.entity.Group;
import archlab.entity.Student;

import java.util.List;


public interface StudentService {

	void newStudent(String name, String surname);

	Student getStudent(String name, String surname);

	List<Student> getStudentsByGroups(Group ... groups);

	List<Student> getStudentsWithAvgMarkMoreThan(double avgMark, int semesterOffset);

	Student getStudentById(long id);

}
