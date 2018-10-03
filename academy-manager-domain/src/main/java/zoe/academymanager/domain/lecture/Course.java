package zoe.academymanager.domain.lecture;

import lombok.*;
import zoe.academymanager.domain.EnableStatus;
import zoe.academymanager.domain.student.SchoolType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseId")
	private Long courseId;

	@OneToMany(mappedBy = "courseId", targetEntity = CourseComposition.class)
	private List<CourseComposition> courseCompositions;

	@Column(name = "courseName", nullable = false)
	private String courseName;

	@Enumerated(EnumType.STRING)
	@Column(name = "schoolType", nullable = false)
	private SchoolType schoolType;

	@Column(name = "price", nullable = false)
	private Long price;

	@Enumerated(EnumType.STRING)
	@Column(name = "enableStatus", nullable = false)
	private EnableStatus enableStatus;
}