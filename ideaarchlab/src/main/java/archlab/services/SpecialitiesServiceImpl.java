package archlab.services;

import archlab.entity.Faculty;
import archlab.entity.Speciality;
import archlab.repository.SpecialitiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SpecialitiesServiceImpl implements SpecialitiesService {
	@Autowired
	private SpecialitiesDao specialitiesDao;

	@Override
	public List<Speciality> getAll() {
		List<Speciality> list = new ArrayList<>();
		for (Speciality spec : specialitiesDao.findAll()) {
			list.add(spec);
		}
		return list;
	}

	@Override
	public List<Speciality> getByFaculty(Faculty faculty) {
		return specialitiesDao.findByFaculty(faculty);
	}
}
