package zoe.academymanager.domain.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    public User registerStudent(StudentRegisterForm form) {
        User user = User.builder()
                .loginId(UUID.randomUUID().toString().replace("-", ""))
                .password(UUID.randomUUID().toString().replace("-", ""))
                .name(form.getName())
                .gender(Gender.UNKNOWN)
                .phoneNumber(form.getPhoneNumber())
                .email(null)
                .role(Role.STUDENT)
                .userStatus(UserStatus.ACTIVE)
                .createdAt(new Date())
                .grantedAt(new Date())
                .address(form.getAddress())
                .birth(form.getBirth())
                .build();
        return userRepository.save(user);
    }
}
