package archlab.services;

import archlab.entity.Faculty;
import archlab.repository.FacultiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultiesDao facultiesDao;

	@Override
	public List<Faculty> getAll() {
		List<Faculty> list = new ArrayList<>();
		for (Faculty faculty : facultiesDao.findAll()) {
			list.add(faculty);
		}
		return list;
	}
}
