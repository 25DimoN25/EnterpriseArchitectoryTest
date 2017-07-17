package archlab.repository;

import archlab.entity.Post;
import archlab.entity.Student;
import archlab.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeachersDao extends CrudRepository<Teacher, Long> {

	@Query("SELECT t FROM Teachers t WHERE LOWER(firstName) = LOWER(?1) AND LOWER(lastName) = LOWER(?2)")
	Teacher findByName(String firstName, String lastName);

	List<Teacher> findByPost(Post post);

}
