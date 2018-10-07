package zoe.academymanager.domain.student;

import lombok.*;
import zoe.academymanager.domain.lecture.CourseRegistration;

import javax.persistence.*;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private Long studentId;

	@Column(name = "userId", nullable = false)
	private String userId;

	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId", updatable = false, insertable = false)
	private User user;

	@Column(name = "school", nullable = false)
	private String school;

	@Enumerated(EnumType.STRING)
	@Column(name = "schoolYear", nullable = false)
	private SchoolYear schoolYear;

	@Column(name = "courseRegistrationId")
	private Long courseRegistrationId;

	@ManyToOne
	@JoinColumn(name = "courseRegistrationId", updatable = false, insertable = false)
	private CourseRegistration courseRegistration;
}