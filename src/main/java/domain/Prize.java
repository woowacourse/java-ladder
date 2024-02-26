package domain;

public class Prize {

    private final String value;

    public Prize(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
