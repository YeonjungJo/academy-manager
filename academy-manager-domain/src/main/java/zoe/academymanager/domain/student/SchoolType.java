package zoe.academymanager.domain.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Arrays;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SchoolType {
    ELEMENTARY("초등학교", "초등"),
    MIDDLE("중학교", "중학"),
    HIGH("고등학교", "고등");

    private String code;

    private String description;

    SchoolType(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public String getName() {
        return name();
    }

    public static SchoolType getByDesc(String desc) {
        return Arrays.stream(SchoolType.values()).filter(it -> it.getDescription().equals(desc)).findAny().orElse(null);
    }
}
