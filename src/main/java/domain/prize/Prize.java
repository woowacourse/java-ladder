package domain.prize;

public class Prize {
    private static final int MINIMUM_PRIZE_LENGTH = 1;
    private static final int MAXIMUM_PRIZE_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_MESSAGE = "[ERROR] 실행 결과의 길이는 " + MINIMUM_PRIZE_LENGTH +
            "보다 크거나, " + MAXIMUM_PRIZE_LENGTH + "보다 작아야 합니다.";

    private final String value;

    public Prize(final String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(final String value) {
        if (value.length() < MINIMUM_PRIZE_LENGTH || value.length() > MAXIMUM_PRIZE_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
