package ladder.domain;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateBlankAndNull(value);
        validateLength(value);
    }

    private void validateBlankAndNull(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateLength(String value) {
        if (value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    public String value() {
        return value;
    }

    public boolean haveSameValueWith(String nameValue) {
        return this.value.equals(nameValue);
    }
}
