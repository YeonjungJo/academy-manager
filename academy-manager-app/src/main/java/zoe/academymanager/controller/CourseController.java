package zoe.academymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zoe.academymanager.application.CourseApplication;
import zoe.academymanager.application.UserApplication;
import zoe.academymanager.domain.lecture.CourseDto;
import zoe.academymanager.domain.lecture.CourseOption;
import zoe.academymanager.domain.lecture.CourseRegisterForm;
import zoe.academymanager.domain.student.StudentDto;
import zoe.academymanager.domain.student.StudentRegisterForm;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseApplication courseApplication;

    @GetMapping(value = "/courses/options")
    public CourseOption listOptions() {
        return new CourseOption();
    }

    @GetMapping(value = "/courses")
    public List<CourseDto> listCourse() {
        return courseApplication.list();
    }

    @PostMapping(value = "/courses/register")
    public void register(@RequestBody CourseRegisterForm form) {
        courseApplication.register(form);
    }
}
