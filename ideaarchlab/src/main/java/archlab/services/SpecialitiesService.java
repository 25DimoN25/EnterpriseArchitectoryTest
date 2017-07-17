package archlab.services;

import archlab.entity.Faculty;
import archlab.entity.Speciality;

import java.util.List;

public interface SpecialitiesService {
	List<Speciality> getAll();

	List<Speciality> getByFaculty(Faculty faculty);
}
