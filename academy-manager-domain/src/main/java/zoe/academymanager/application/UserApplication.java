package zoe.academymanager.application;

import zoe.academymanager.domain.student.StudentDto;

import java.util.List;

public interface UserApplication {
	List<StudentDto> students();
}
