package domain;

import constant.domain.NameExceptionMessage;

import java.util.Objects;

public class Name {

    public static final int MAX_OF_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNoName(name);
        validateNameLength(name);
        validateForbidName(name);
        this.name = name;
    }

    private void validateNoName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NameExceptionMessage.NO_NAME.getExceptionMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException(NameExceptionMessage.OUT_OF_RANGE_NAME_LENGTH.getExceptionMessage());
        }
    }

    private void validateForbidName(String name) {
        if (Objects.equals(name, "all") || Objects.equals(name, "exit")) {
            throw new IllegalArgumentException("[ERROR] all 또는 exit는 이름이 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
