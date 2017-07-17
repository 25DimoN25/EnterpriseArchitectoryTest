package archlab.services;

import archlab.entity.Group;
import archlab.entity.GroupType;
import archlab.entity.Speciality;
import archlab.entity.Student;

import java.sql.Date;
import java.util.List;

public interface GroupsService {

	void newGroup(int course, boolean fulltime, GroupType type, Speciality speciality);

	Group getGroup(int course, boolean fulltime, GroupType type, Speciality speciality, Date creationTime);

	void removeStudentsFromGroup(Group group, Student ... students);

	void addStudentsInGroup(Group group, Student ... student);

	List<Group> getBySpeciality(Speciality speciality);

	Group getById(long id);
}
