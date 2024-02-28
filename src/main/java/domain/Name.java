package domain;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String inputName) {
        validateAvailableLength(inputName);
        validateBlank(inputName);
        validateContainBlankInName(inputName);
    }

    private void validateAvailableLength(String inputName) {
        if (inputName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("입력값은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateBlank(String initialInput) {
        if (initialInput.isBlank()) {
            throw new IllegalArgumentException("공백으로 이루어진 값은 입력할 수 없습니다.");
        }
    }

    private void validateContainBlankInName(String inputName) {
        if (inputName.contains(" ")) {
            throw new IllegalArgumentException("중간에 공백이 포함된 값은 입력할 수 없습니다.");
        }
    }

    public boolean isAll() {
        return value.equals("all");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
