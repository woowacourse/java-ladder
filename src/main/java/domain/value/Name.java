package domain.value;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH_INCLUSIVE = 5;
    private static final int NAME_MIN_LENGTH_INCLUSIVE = 1;

    private final String value;

    public Name(final String name) {
        validateLength(name);
        this.value = name;
    }

    private void validateLength(final String name) {
        if (name.length() < NAME_MIN_LENGTH_INCLUSIVE
                || NAME_MAX_LENGTH_INCLUSIVE < name.length()) {
            throw new IllegalArgumentException("이름은 1글자에서 5글자 사이여야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }

    public int length() {
        return value.length();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(getValue(), name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
