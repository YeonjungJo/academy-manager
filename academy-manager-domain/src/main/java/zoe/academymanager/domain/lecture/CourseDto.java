package zoe.academymanager.domain.lecture;

import lombok.*;
import zoe.academymanager.domain.student.SchoolType;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseDto {

	private String courseName;
	private Long price;
	private SchoolType type;
	private Integer math;
	private Integer eng;
	private Integer discuss;

	public static CourseDto from(Course course) {
		return CourseDto.builder()
			.courseName(course.getCourseName())
			.price(course.getPrice())
			.type(course.getSchoolType())
			.math(get(course, Subject.MATH))
			.eng(get(course, Subject.ENGLISH))
			.discuss(get(course, Subject.DISCUSS))
			.build();
	}

	private static Integer get(Course course, Subject subject) {
		return course.getCourseCompositions().stream()
			.filter(o -> o.getSubject() == subject)
			.findAny()
			.map(CourseComposition::getTime)
			.orElse(0);
	}
}
