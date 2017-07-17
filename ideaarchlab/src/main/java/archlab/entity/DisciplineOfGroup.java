package archlab.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "DisciplinesList")
public class DisciplineOfGroup extends Identify {

	@ManyToOne @JoinColumn(name = "disciplineId")
	private Discipline discipline;
	@ManyToOne @JoinColumn(name = "groupId")
	private Group group;
	private int semester;

	public DisciplineOfGroup() {
	}

	public DisciplineOfGroup(Discipline discipline, Group group, int semester) {

		this.discipline = discipline;
		this.group = group;
		this.semester = semester;
	}

	public Discipline getDiscipline() {

		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DisciplineOfGroup that = (DisciplineOfGroup) o;

		if (semester != that.semester) return false;
		if (!discipline.equals(that.discipline)) return false;
		return group.equals(that.group);
	}

	@Override
	public int hashCode() {
		int result = discipline.hashCode();
		result = 31 * result + group.hashCode();
		result = 31 * result + semester;
		return result;
	}

	@Override
	public String toString() {
		return "DisciplineOfGroup{" +
				"discipline=" + discipline +
				", group=" + group +
				", semester=" + semester +
				'}';
	}
}
