package zoe.academymanager.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zoe.academymanager.domain.student.Role;
import zoe.academymanager.domain.student.StudentDto;
import zoe.academymanager.domain.student.StudentService;
import zoe.academymanager.domain.student.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserApplicationImpl implements UserApplication {

	@Autowired
	private StudentService studentService;

	@Override
	public List<StudentDto> students() {
		return studentService.list().stream()
			.map(StudentDto::from)
			.collect(Collectors.toList());
	}
}
