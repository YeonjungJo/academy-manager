package zoe.academymanager.domain.student;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentRegisterForm {
	private String name;
	private Date birth;
	private String schoolName;
	private String schoolType;
	private String grade;
	private String phoneNumber;
	private String parentPhoneNumber;
	private String address;
}
