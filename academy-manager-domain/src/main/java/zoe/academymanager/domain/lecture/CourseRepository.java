package zoe.academymanager.domain.lecture;

import org.springframework.data.jpa.repository.JpaRepository;
import zoe.academymanager.domain.EnableStatus;
import zoe.academymanager.domain.student.Student;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findAllByEnableStatusIn(List<EnableStatus> notDeleted);

    Course findByCourseNameAndEnableStatusIn(String name, List<EnableStatus> notDeleted);
}
