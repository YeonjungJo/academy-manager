package zoe.academymanager.application;

import zoe.academymanager.domain.student.StudentDto;
import zoe.academymanager.domain.student.StudentRegisterForm;

import java.util.List;

public interface UserApplication {
	List<StudentDto> students();

	void register(StudentRegisterForm form);
}
