package zoe.academymanager.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zoe.academymanager.domain.lecture.Course;
import zoe.academymanager.domain.lecture.CourseDto;
import zoe.academymanager.domain.lecture.CourseRegisterForm;
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

    public void register(CourseRegisterForm form) {
        Course byName = courseService.findByName(form.getName());
        if (byName != null) {
        }
        courseService.register(form);
    }
}
