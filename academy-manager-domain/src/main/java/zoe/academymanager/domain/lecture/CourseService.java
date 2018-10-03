package zoe.academymanager.domain.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static zoe.academymanager.domain.EnableStatus.NOT_DELETED;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> list() {
		return courseRepository.findAllByEnableStatusIn(NOT_DELETED);
	}
}
