package domain.player;

import java.util.Objects;

public class Name {
    private static final Integer NAME_MAX_SIZE = 5;
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (!(object instanceof final Name name)) return false;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(String inputName) {
        validateAvailableLength(inputName);
        validateBlank(inputName);
        validateContainBlankInName(inputName);
    }

    private void validateAvailableLength(String inputName) {
        if (inputName.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException(String.format("이름은 최대 %d글자 입니다!", NAME_MAX_SIZE));
        }
    }

    private void validateBlank(String initialInput) {
        if (initialInput.isBlank()) {
            throw new IllegalArgumentException("공백으로 이루어진 이름은 사용할 수 없습니다.");
        }
    }

    private void validateContainBlankInName(String inputName) {
        if (inputName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백을 포함할 수 없습니다.");
        }
    }
}
