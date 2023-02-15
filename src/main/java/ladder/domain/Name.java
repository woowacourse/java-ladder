package ladder.domain;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.isBlank() || value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

}
