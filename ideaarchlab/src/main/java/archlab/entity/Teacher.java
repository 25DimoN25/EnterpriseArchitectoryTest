package archlab.entity;

import javax.persistence.*;

@Entity(name = "Teachers")
public class Teacher extends Identify {

	private String firstName;

	private String lastName;

	@Column(name = "postId") @Enumerated
	private Post post;

	public Teacher() {
	}

	public Teacher(String firstName, String lastName, Post post) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.post = post;
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

	public Post getPost() {
		return post;
	}

	public void setPostId(Post post) {
		this.post = post;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Teacher teacher = (Teacher) o;

		if (!firstName.equals(teacher.firstName)) return false;
		if (!lastName.equals(teacher.lastName)) return false;
		return post.equals(teacher.post);
	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + post.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", post=" + post +
				'}';
	}
}
