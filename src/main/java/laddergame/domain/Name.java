package laddergame.domain;

import java.util.Objects;

public class Name {

    private static final String NAME_LENGTH_RANGE_MESSAGE = "1이상 5글자 이하의 이름을 입력해 주세요.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateNameLength(name);
        this.name = name.trim();
    }

    private void validateNameLength(final String name) {
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_RANGE_MESSAGE);
        }
    }

    private static boolean isOutOfRange(final String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return this.name.length();
    }
}
