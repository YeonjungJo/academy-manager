package zoe.academymanager.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zoe.academymanager.domain.lecture.CourseDto;
import zoe.academymanager.domain.lecture.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseApplication {

	@Autowired
	private CourseService courseService;

	public List<CourseDto> list() {
		return courseService.list().stream().map(CourseDto::from).collect(Collectors.toList());
	}
}
