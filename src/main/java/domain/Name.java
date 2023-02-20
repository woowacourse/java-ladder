package domain;


import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateBlank(value);
        validateLength(value);
    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(String.format("이름은 공백이거나 비어있을 수 없습니다. 입력값 : %s", value));
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 1글자 이상, 5글자 이하여야합니다. 입력값 : %s", value));
        }
    }

    public String value() {
        return value;
    }

    public int length() {
        return value.length();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Name otherName = (Name) object;
        return value.equals(otherName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
