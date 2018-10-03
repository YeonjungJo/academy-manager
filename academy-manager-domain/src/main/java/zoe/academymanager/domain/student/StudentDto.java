package zoe.academymanager.domain.student;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentDto {
	private String name;
	private SchoolType type;
	private Date engRegisterDate;
	private Date mathRegisterDate;
	private String registerType;
	private Long originPrice;
	private Long discountPrice;
	private Long finalPrice;
	private String notes;

	public static StudentDto from(Student student) {
		Long originPrice = student.getCourseRegistration().getCourse().getPrice();

		return StudentDto.builder()
			.name(student.getUser().getName())
			.type(student.getSchoolYear().getSchoolType())
			.registerType(student.getCourseRegistration().getCourse().getCourseName())
			.originPrice(originPrice)
			.finalPrice(originPrice)
			.build();
	}
}
