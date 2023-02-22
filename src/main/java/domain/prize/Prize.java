package domain.prize;

public class Prize {

    private static final int PRIZE_MAX_LENGTH = 5;

    private final String value;

    public Prize(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        validateNotBlank(value);
        validateValueLength(value);
    }

    private void validateNotBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("당첨 항목은 공백일 수 없습니다.");
        }
    }

    private void validateValueLength(final String name) {
        if (name.length() > PRIZE_MAX_LENGTH) {
            throw new IllegalArgumentException("당첨 항목은 최대 5글자까지 가능합니다.");
        }
    }

    public String getValue() {
        return value;
    }

}
