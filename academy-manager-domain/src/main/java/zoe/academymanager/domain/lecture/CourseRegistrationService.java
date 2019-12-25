package zoe.academymanager.domain.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegistrationService {
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;
}
