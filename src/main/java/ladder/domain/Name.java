package ladder.domain;

import java.util.Objects;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        String name = value.trim();
        validateLength(name);
        this.value = name;
    }

    private void validateLength(String name) {
        int nameLength = name.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 공백을 제외한 최소 1글자 최대 5글자까지 부여할 수 있습니다.");
        }
    }

    public int getLength() {
        return value.length();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that instanceof Name name) {
            return Objects.equals(this.value, name.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
