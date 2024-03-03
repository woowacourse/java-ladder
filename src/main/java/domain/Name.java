package domain;


import java.util.Objects;

public class Name {

    public static final String UNAVAILABLE_NAME = "게임 명령어는 이름으로 사용할 수 없습니다.";
    private static final int MINIMUM_NAME = 1;
    private static final int MAXIMUM_NAME = 5;
    public static final String INVALID_NAME_LENGTH = "이름은 " + MINIMUM_NAME + "자 이상 " + MAXIMUM_NAME + "자 이하 이어야 합니다.";
    private final String value;

    public Name(final String value) {
        validateNameLength(value);
        validateUsableName(value);
        this.value = value;
    }

    private void validateNameLength(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private void validateUsableName(final String value) {
        if (Commands.exists(value)) {
            throw new IllegalArgumentException(UNAVAILABLE_NAME);
        }
    }

    public boolean isSame(final String target) {
        return value.equals(target);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
