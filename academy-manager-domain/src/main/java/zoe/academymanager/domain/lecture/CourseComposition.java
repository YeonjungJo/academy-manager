package zoe.academymanager.domain.lecture;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "course_compositions")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseComposition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseCompositionId")
	private Long courseCompositionId;

	@Column(name = "courseId")
	private Long courseId;

	@Enumerated(EnumType.STRING)
	@Column(name = "subject", nullable = false)
	private Subject subject;

	@Column(name = "time", nullable = false)
	private Integer time;
}