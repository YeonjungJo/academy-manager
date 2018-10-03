package zoe.academymanager.domain.lecture;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Subject {
	ENGLISH("영어"),
	MATH("수학"),
	DISCUSS("토론");

	@Getter
	private String description;

	Subject(String description){
		this.description = description;
	}
}
