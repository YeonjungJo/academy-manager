package zoe.academymanager.domain.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoe.academymanager.domain.EnableStatus;

import javax.transaction.Transactional;
import java.util.List;

import static zoe.academymanager.domain.EnableStatus.NOT_DELETED;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseCompositionRepository courseCompositionRepository;

    public List<Course> list() {
        return courseRepository.findAllByEnableStatusIn(NOT_DELETED);
    }

    public Course findByName(String name) {
        return courseRepository.findByCourseNameAndEnableStatusIn(name, NOT_DELETED);
    }

    @Transactional
    public void register(CourseRegisterForm form) {
        Course course = Course.builder()
            .courseName(form.getName())
            .schoolType(form.getSchoolType())
            .price(form.getPrice())
            .enableStatus(EnableStatus.ACTIVE)
            .build();
        courseRepository.save(course);

        form.getAssigned().forEach((key, value) -> {
            CourseComposition courseComposition = CourseComposition.builder()
                .courseId(course.getCourseId())
                .subject(key)
                .time(value)
                .build();
            courseCompositionRepository.save(courseComposition);
        });
    }
}
