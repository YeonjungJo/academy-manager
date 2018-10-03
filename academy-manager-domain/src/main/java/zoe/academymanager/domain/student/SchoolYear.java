package zoe.academymanager.domain.student;

import lombok.Getter;

@Getter
public enum SchoolYear {
	ELEMENTARY_1(SchoolType.ELEMENTARY, 1),
	ELEMENTARY_2(SchoolType.ELEMENTARY, 2),
	ELEMENTARY_3(SchoolType.ELEMENTARY, 3),
	ELEMENTARY_4(SchoolType.ELEMENTARY, 4),
	ELEMENTARY_5(SchoolType.ELEMENTARY, 5),
	ELEMENTARY_6(SchoolType.ELEMENTARY, 6);

	private SchoolType schoolType;
	private int year;

	SchoolYear(SchoolType type, int year) {
		this.schoolType = type;
		this.year = year;
	}
}
