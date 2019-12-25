package zoe.academymanager.domain.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Transactional
    public void register(StudentRegisterForm form) {
        User user = userService.registerStudent(form);

        Student student = Student.builder()
                .userId(user.getUserId())
                .school(form.getSchoolName())
                .schoolYear(SchoolYear.get(form.getSchoolType(), form.getGrade()))
                .build();
        studentRepository.save(student);
    }
}