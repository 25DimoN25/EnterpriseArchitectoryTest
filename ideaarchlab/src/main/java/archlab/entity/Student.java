package archlab.entity;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.List;

@Entity(name = "Students")
public class Student extends Identify {

	private String firstName;

	private String lastName;

	private Date admission;

	private Date expulsion;

	@ManyToMany(mappedBy = "students")
	private List<Group> groups;

	@OneToMany @JoinColumn(name = "studentId")
	private List<Mark> marks;

	public Student() {
	}

	public Student(String firstName, String lastName, Date admission, Date expulsion) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.admission = admission;
		this.expulsion = expulsion;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getAdmission() {
		return admission;
	}

	public void setAdmission(Date admission) {
		this.admission = admission;
	}

	public Date getExpulsion() {
		return expulsion;
	}

	public void setExpulsion(Date expulsion) {
		this.expulsion = expulsion;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Student student = (Student) o;

		if (!firstName.equals(student.firstName)) return false;
		if (!lastName.equals(student.lastName)) return false;
		if (!admission.equals(student.admission)) return false;
		return expulsion != null ? expulsion.equals(student.expulsion) : student.expulsion == null;
	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + admission.hashCode();
		result = 31 * result + (expulsion != null ? expulsion.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", admission=" + admission +
				", expulsion=" + expulsion +
				'}';
	}
}
