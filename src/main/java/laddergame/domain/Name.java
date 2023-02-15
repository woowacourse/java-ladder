package laddergame.domain;

import java.util.Objects;

public class Name {

    private static final String NAME_LENGTH_RANGE_MESSAGE = "1이상 5글자 이하의 이름을 입력해 주세요.";

    private final String name;

    public Name(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_RANGE_MESSAGE);
        }
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
