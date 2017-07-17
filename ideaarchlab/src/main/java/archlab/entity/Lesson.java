package archlab.entity;

import javax.persistence.*;

@Entity(name = "Lessons")
public class Lesson extends Identify {

	@Column(name = "typeId") @Enumerated
	private LessonType type;

	@ManyToOne @JoinColumn(name = "disciplineId")
	private Discipline discipline;

	@ManyToOne @JoinColumn(name = "groupId")
	private Group group;

	@ManyToOne @JoinColumn(name = "teacherId")
	private Teacher teacher;

	private long hours;

	public Lesson() {
	}

	public Lesson(LessonType type, Discipline discipline, Group group, Teacher teacher, long hours) {
		this.type = type;
		this.discipline = discipline;
		this.group = group;
		this.teacher = teacher;
		this.hours = hours;
	}

	public LessonType getType() {
		return type;
	}

	public void setType(LessonType type) {
		this.type = type;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public long getHours() {
		return hours;
	}

	public void setHours(long hours) {
		this.hours = hours;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Lesson lesson = (Lesson) o;

		if (hours != lesson.hours) return false;
		if (!type.equals(lesson.type)) return false;
		if (!discipline.equals(lesson.discipline)) return false;
		if (!group.equals(lesson.group)) return false;
		return teacher.equals(lesson.teacher);
	}

	@Override
	public int hashCode() {
		int result = type.hashCode();
		result = 31 * result + discipline.hashCode();
		result = 31 * result + group.hashCode();
		result = 31 * result + teacher.hashCode();
		result = 31 * result + (int) (hours ^ (hours >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Lesson{" +
				"id=" + id +
				", type=" + type +
				", discipline=" + discipline +
				", group=" + group +
				", teacher=" + teacher +
				", hours=" + hours +
				'}';
	}
}
