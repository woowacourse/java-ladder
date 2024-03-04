package domain;

import java.util.Objects;

public class Name {

    public static final int MAX_OF_NAME_LENGTH = 5;
    public static final String NO_NAME = "[ERROR] 이름이 없습니다.";
    public static final String OUT_OF_RANGE_NAME_LENGTH =
            "[ERROR] 이름의 길이는 " + MAX_OF_NAME_LENGTH + "글자를 초과할 수 없습니다.";
    public static final String DISALLOWED_NAME = "[ERROR] " + Command.getCommandToString() + "는 이름이 될 수 없습니다.";

    private final String name;

    public Name(String name) {
        validateNoName(name);
        validateNameLength(name);
        validateForbidName(name);
        this.name = name;
    }

    private void validateNoName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NO_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NAME_LENGTH);
        }
    }

    private void validateForbidName(String name) {
        if (Command.contains(name)) {
            throw new IllegalArgumentException(DISALLOWED_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
