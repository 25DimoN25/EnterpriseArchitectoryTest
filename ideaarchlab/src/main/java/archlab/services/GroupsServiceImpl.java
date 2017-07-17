package archlab.services;

import archlab.entity.Group;
import archlab.entity.GroupType;
import archlab.entity.Speciality;
import archlab.entity.Student;
import archlab.repository.GroupsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class GroupsServiceImpl implements GroupsService {
	@Autowired
	private GroupsDao groupsDao;

	@Override
	public void newGroup(int course, boolean fulltime, GroupType type, Speciality speciality) {
		Group group = new Group();
		group.setCourse(course);
		group.setFulltime(fulltime);
		group.setType(type);
		group.setSpeciality(speciality);
		group.setCreationDate(Date.valueOf(LocalDate.now()));

		groupsDao.save(group);
	}

	@Override
	public Group getGroup(int course, boolean fulltime, GroupType type, Speciality speciality, Date creationTime) {
		return groupsDao.findByAllData(course, speciality, type, fulltime).stream()
				.filter(g -> g.getCreationDate().equals(creationTime))
				.findFirst().get();
	}

	@Override
	public void removeStudentsFromGroup(Group group, Student... students) {
		group.getStudents().removeAll(Arrays.asList(students));

//		groupsDao.delete(group);
//		group.getStudents().removeAll(Arrays.asList(students));
//		groupsDao.save(group);
	}

	@Override
	public void addStudentsInGroup(Group group, Student... students) {
		group.getStudents().addAll(Arrays.asList(students));
	}

	@Override
	public List<Group> getBySpeciality(Speciality speciality) {
		return groupsDao.findBySpecialityAndCreationDateBetween(speciality, Date.valueOf("1000-01-01"), Date.valueOf(LocalDate.now()));
	}

	@Override
	public Group getById(long id) {
		return groupsDao.findOne(id);
	}
}
