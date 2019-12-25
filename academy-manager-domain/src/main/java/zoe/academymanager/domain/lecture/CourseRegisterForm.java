package zoe.academymanager.domain.lecture;

import lombok.*;
import zoe.academymanager.domain.student.SchoolType;

import java.util.Map;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseRegisterForm {
    private String name;
    private SchoolType schoolType;
    private Map<Subject, Integer> assigned;
    private Long price;
}
