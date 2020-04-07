package zoe.academymanager.domain.student;

import lombok.*;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@Builder // NOSONAR
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentDto {
    private Long studentId;
    private String name;
    private SchoolType type;
    private Date engRegisterDate;
    private Date mathRegisterDate;
    private String registerType;
    private Long originPrice;
    private Long discountPrice;
    private Long finalPrice;
    private Date registeredAt;
    private String notes;

    public static StudentDto from(Student student) {
        Long originPrice = Optional.ofNullable(student.getCourseRegistration()).map(it -> it.getCourse().getPrice()).orElse(0L);

        return StudentDto.builder()
            .studentId(student.getStudentId())
            .name(student.getUser().getName())
            .type(student.getSchoolYear().getSchoolType())
            .registerType(Optional.ofNullable(student.getCourseRegistration()).map(it -> it.getCourse().getCourseName()).orElse(Strings.EMPTY))
            .originPrice(originPrice)
            .finalPrice(originPrice)
            .registeredAt(student.getUser().getCreatedAt())
            .build();
    }
}
