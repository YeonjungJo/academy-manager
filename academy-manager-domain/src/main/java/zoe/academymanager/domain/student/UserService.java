package zoe.academymanager.domain.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> listByRole(Role role) {
		return userRepository.findAllByRole(role);
	}
}
