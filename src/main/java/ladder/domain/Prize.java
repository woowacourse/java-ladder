package ladder.domain;

public class Prize {

    private static final int MAXIMUM_PRIZE_LENGTH = 5;

    private final String value;

    public Prize(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        validateBlank(value);
        validateLength(value);
    }

    private void validateBlank(final String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("당첨 항목은 공백일 수 없습니다. 현재 입력한 값은 " + value + " 입니다.");
        }
    }

    private void validateLength(final String value) {
        if (isLong(value)) {
            throw new IllegalArgumentException(
                    "당첨 항목은 최대 " + MAXIMUM_PRIZE_LENGTH + "글자까지 가능합니다. 현재 입력한 값은 " + value + " 입니다.");
        }
    }

    private boolean isLong(final String value) {
        return value.length() > MAXIMUM_PRIZE_LENGTH;
    }

    public String getValue() {
        return value;
    }
}
