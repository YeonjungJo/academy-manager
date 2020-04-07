package zoe.academymanager.domain.lecture;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseRegisterForm {
    private String name;
    private String schoolType;
    private Map<String, Integer> assigned;
    private Long price;
}
