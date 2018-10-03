package zoe.academymanager.domain.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> list() {
		return studentRepository.findAll();
	}
}
