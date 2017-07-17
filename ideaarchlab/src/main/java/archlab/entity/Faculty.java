package archlab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Faculties")
public class Faculty extends Identify {

	private String name;

	public Faculty() {
	}

	public Faculty(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Faculty facultet = (Faculty) o;

		if (id != facultet.id) return false;
		return name.equals(facultet.name);
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + name.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Faculty{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
