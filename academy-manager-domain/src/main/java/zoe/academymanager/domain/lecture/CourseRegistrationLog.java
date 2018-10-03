package zoe.academymanager.domain.lecture;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "course_registration_log")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseRegistrationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseRegistrationLogId")
	private Long courseRegistrationLogId;

	@Column(name = "courseRegistrationId")
	private Long courseRegistrationId;

	@Column(name = "studentId", nullable = false)
	private String studentId;

	@Column(name = "courseId", nullable = false)
	private Long courseId;

	@Column(name = "registrationDate", nullable = false)
	private Date registrationDate;

	@Column(name = "description")
	private String description;
}