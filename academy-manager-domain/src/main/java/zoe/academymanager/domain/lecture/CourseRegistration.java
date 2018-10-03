package zoe.academymanager.domain.lecture;

import lombok.*;
import zoe.academymanager.domain.EnableStatus;
import zoe.academymanager.domain.student.SchoolType;
import zoe.academymanager.domain.student.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "course_registrations")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseRegistrationId")
	private Long courseRegistrationId;

	@Column(name = "studentId", nullable = false)
	private String studentId;

	@Column(name = "courseId", nullable = false)
	private Long courseId;

	@ManyToOne
	@JoinColumn(name = "courseId", referencedColumnName = "courseId", updatable = false, insertable = false)
	private Course course;

	@Column(name = "registrationDate", nullable = false)
	private Date registrationDate;
}