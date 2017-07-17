package archlab.config;

import archlab.entity.*;
import archlab.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class WebController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private SpecialitiesService specialitiesService;

	@Autowired
	private GroupsService groupsService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private MarksService marksService;

	@GetMapping("/")
	private String getAllGroups(Model model) {

		List<Faculty> faculties = facultyService.getAll();
		Map<Faculty, Map<Speciality, List<Group>>> facultiesSpeciality = new HashMap<>();
		for (Faculty faculty : faculties) {
			List<Speciality> specialities = specialitiesService.getByFaculty(faculty);
			Map<Speciality, List<Group>> specialityGroups = new HashMap<>();
			for (Speciality speciality : specialities) {
				List<Group> groups = groupsService.getBySpeciality(speciality);

				groups.sort(Comparator.comparing(Group::getCourse)
							.thenComparing(g -> g.getSpeciality().getName()));

				specialityGroups.put(speciality, groups);
			}
			facultiesSpeciality.put(faculty, specialityGroups);
		}

		model.addAttribute("facultiesSpeciality", facultiesSpeciality);

		return "index";
	}


	@GetMapping("/group{id}")
	private String getStudentsPerGroup(@PathVariable("id") long id, Model model) {
		Group group = groupsService.getById(id);

		List<Student> students = studentService.getStudentsByGroups(group);

		model.addAttribute("group", group);
		model.addAttribute("students", students);

		return "group";
	}

	@GetMapping("/student{id}")
	private String getMarksByStudent(@PathVariable("id") long id, Model model) {
		Student student = studentService.getStudentById(id);

		List<Mark> marks = marksService.getAllMarksOfStudent(student);

		model.addAttribute("student", student);
		model.addAttribute("marks", marks);

		return "marks";
	}

	@GetMapping("/marksOfGroup{id}")
	private String getMarksOfGroup(@PathVariable("id") long groupId,
								   //@RequestParam(name = "semester", required = false, defaultValue = "1") int semester,
								   Model model) {

		Group group = groupsService.getById(groupId);

		List<Mark> markList = marksService.getAllMarksOfGroup(group);

		Map<Student, Map<Discipline, List<Mark>>> marks = new LinkedHashMap<>();

		markList.stream()
				.collect(Collectors.groupingBy(Mark::getStudent))
				.entrySet().stream()
				.forEach(entry -> marks.put(
								entry.getKey(),
								entry.getValue().stream()
									.collect(Collectors.groupingBy(Mark::getDiscipline))
				));

		model.addAttribute("group", group);
		model.addAttribute("marks", marks);


		return "groupMarks";
	}
}
