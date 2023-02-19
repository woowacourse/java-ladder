package domain.vo;

public class Width {

    private static final int MIN_WIDTH = 1;
    private static final int MAX_WIDTH = 99;
    private static final String WIDTH_NOT_IN_RANGE_ERROR_MESSAGE = "참여자의 수는 %d~%d명 입니다.";
    private final int value;

    public Width(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int target) {
        if (target < MIN_WIDTH || target > MAX_WIDTH) {
            throw new IllegalArgumentException(String.format(WIDTH_NOT_IN_RANGE_ERROR_MESSAGE,
                MIN_WIDTH + 1, MAX_WIDTH + 1));
        }
    }

    public int getValue() {
        return value;
    }
}
