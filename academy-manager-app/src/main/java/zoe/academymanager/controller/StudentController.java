package zoe.academymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zoe.academymanager.application.UserApplication;
import zoe.academymanager.domain.student.StudentDto;
import zoe.academymanager.domain.student.StudentRegisterForm;

import java.util.List;

@RestController
public class StudentController {

	@Autowired
	private UserApplication userApplication;

	@GetMapping(value = "/students")
	public List<StudentDto> listStudent() {
		return userApplication.students();
	}

	@PostMapping(value = "/students/register")
	public void register(@RequestBody StudentRegisterForm form) {
		userApplication.register(form);
	}
}
