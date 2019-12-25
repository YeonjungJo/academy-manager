package zoe.academymanager.domain.lecture;

import lombok.*;
import zoe.academymanager.domain.student.SchoolType;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseOption {
    private Subject[] subjects = Subject.values();
    private SchoolType[] schoolTypes = SchoolType.values();
}
