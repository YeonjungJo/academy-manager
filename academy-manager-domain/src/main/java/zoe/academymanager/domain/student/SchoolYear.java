package zoe.academymanager.domain.student;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SchoolYear {
    ELEMENTARY_1(SchoolType.ELEMENTARY, 1),
    ELEMENTARY_2(SchoolType.ELEMENTARY, 2),
    ELEMENTARY_3(SchoolType.ELEMENTARY, 3),
    ELEMENTARY_4(SchoolType.ELEMENTARY, 4),
    ELEMENTARY_5(SchoolType.ELEMENTARY, 5),
    ELEMENTARY_6(SchoolType.ELEMENTARY, 6),
    MIDDLE_1(SchoolType.MIDDLE, 1),
    MIDDLE_2(SchoolType.MIDDLE, 2),
    MIDDLE_3(SchoolType.MIDDLE, 3),
    HIGH_1(SchoolType.HIGH, 1),
    HIGH_2(SchoolType.HIGH, 2),
    HIGH_3(SchoolType.HIGH, 3);

    private SchoolType schoolType;
    private int year;

    SchoolYear(SchoolType type, int year) {
        this.schoolType = type;
        this.year = year;
    }

    public static SchoolYear get(String schoolType, String grade) {
        return Arrays.stream(SchoolYear.values())
                .filter(it -> SchoolType.getByDesc(schoolType) == it.getSchoolType())
                .filter(it -> it.getYear() == Integer.parseInt(grade))
                .findAny()
                .orElse(null);
    }
}
