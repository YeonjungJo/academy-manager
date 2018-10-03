package zoe.academymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zoe.academymanager.application.UserApplication;
import zoe.academymanager.domain.student.StudentDto;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private UserApplication userApplication;

	@GetMapping(value = "/students")
	public List<StudentDto> listStudent() {
		return userApplication.students();
	}
}
