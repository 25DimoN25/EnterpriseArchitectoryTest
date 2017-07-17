package archlab.entity;

import javax.persistence.*;

@Entity(name = "Specialities")
public class Speciality extends Identify {
	private String name;

	@ManyToOne @JoinColumn(name = "facultyId")
	private Faculty faculty;

	public Speciality() {
	}

	public Speciality(String name, Faculty faculty) {
		this.name = name;
		this.faculty = faculty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Speciality that = (Speciality) o;

		if (!name.equals(that.name)) return false;
		return faculty.equals(that.faculty);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + faculty.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Speciality{" +
				"id=" + id +
				", name='" + name + '\'' +
				", faculty=" + faculty +
				'}';
	}
}

