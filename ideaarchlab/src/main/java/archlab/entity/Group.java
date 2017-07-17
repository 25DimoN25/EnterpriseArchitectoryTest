package archlab.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "Groups")
public class Group extends Identify {

	private int course;

	@ManyToOne @JoinColumn(name = "specialityId")
	private Speciality speciality;

	@Column(name = "typeId") @Enumerated
	private GroupType type;

	private boolean fulltime;

	private Date creationDate;

	@ManyToMany @JoinTable(name = "GroupList",
		joinColumns = @JoinColumn(name = "groupId"),
		inverseJoinColumns = @JoinColumn(name = "studentId"))
	private List<Student> students;


	public Group() {
	}

	public Group(int course, Speciality speciality, GroupType type, boolean fulltime) {
		this.course = course;
		this.speciality = speciality;
		this.type = type;
		this.fulltime = fulltime;
	}


	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public GroupType getType() {
		return type;
	}

	public void setType(GroupType type) {
		this.type = type;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}

	public Date getCreationDate() {
		return creationDate;
	}
//
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Group group = (Group) o;

		if (course != group.course) return false;
		if (fulltime != group.fulltime) return false;
		if (!speciality.equals(group.speciality)) return false;
		if (type != group.type) return false;
		return creationDate.equals(group.creationDate);
	}

	@Override
	public int hashCode() {
		int result = course;
		result = 31 * result + speciality.hashCode();
		result = 31 * result + type.hashCode();
		result = 31 * result + (fulltime ? 1 : 0);
		result = 31 * result + creationDate.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Group{" +
				"course=" + course +
				", speciality=" + speciality +
				", type=" + type +
				", fulltime=" + fulltime +
				", creationDate=" + creationDate +
				'}';
	}
}
