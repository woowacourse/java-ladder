package laddergame;

public class Name {
    private final String value;

    public Name(final String value) {
        validateBlank(value);
        validateLength(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름에 빈값을 입력할 수 없습니다.");
        }
    }

    private void validateLength(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름길이는 5글자를 넘을 수 없습니다.");
        }
    }
}
