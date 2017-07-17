package archlab.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Marks")
public class Mark extends Identify {

	private Date markTime;

	private int mark;

	@ManyToOne @JoinColumn(name = "disciplineId")
	private Discipline discipline;

	@ManyToOne @JoinColumn(name = "teacherId")
	private Teacher teacher;

	@ManyToOne @JoinColumn(name = "studentId")
	private Student student;

	public Mark() {
	}

	public Mark(Date markTime, int mark, Discipline discipline, Teacher teacher, Student student) {
		this.markTime = markTime;
		this.mark = mark;
		this.discipline = discipline;
		this.teacher = teacher;
		this.student = student;
	}

	public Date getMarkTime() {
		return markTime;
	}

	public void setMarkTime(Date markTime) {
		this.markTime = markTime;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Mark mark1 = (Mark) o;

		if (mark != mark1.mark) return false;
		if (!markTime.equals(mark1.markTime)) return false;
		if (!discipline.equals(mark1.discipline)) return false;
		if (!teacher.equals(mark1.teacher)) return false;
		return student.equals(mark1.student);
	}

	@Override
	public int hashCode() {
		int result = markTime.hashCode();
		result = 31 * result + (int) mark;
		result = 31 * result + discipline.hashCode();
		result = 31 * result + teacher.hashCode();
		result = 31 * result + student.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Mark{" +
				"id=" + id +
				", markTime=" + markTime +
				", mark=" + mark +
				", discipline=" + discipline +
				", teacher=" + teacher +
				", student=" + student +
				'}';
	}
}
