package zoe.academymanager.domain.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SchoolType {
	ELEMENTARY("초등"),
	MIDDLE("중등"),
	HIGH("고등");

	@Getter
	private String description;

	SchoolType(String description) {
		this.description = description;
	}
}
