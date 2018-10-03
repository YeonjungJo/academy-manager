package zoe.academymanager.domain.student;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder //NOSONAR
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;

	@Column(name = "loginId", nullable = false)
	private String loginId;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "name", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;

	@Column(name = "email", nullable = false)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private UserStatus userStatus;

	@Column(name = "createdAt", nullable = false)
	private Date createdAt;

	@Column(name = "grantedAt", nullable = false)
	private Date grantedAt;
}