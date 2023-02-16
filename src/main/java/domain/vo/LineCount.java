package domain.vo;

public class LineCount {
    private static final int MIN_LINE_COUNT = 1;
    private static final int MAX_LINE_COUNT = 99;
    private static final String LINE_COUNT_NOT_IN_RANGE_ERROR_MESSAGE = "참여자의 수는 %d~%d명 입니다.";
    private final int value;

    public LineCount(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int target) {
        if (target < MIN_LINE_COUNT || target > MAX_LINE_COUNT) {
            throw new IllegalArgumentException(String.format(LINE_COUNT_NOT_IN_RANGE_ERROR_MESSAGE, MIN_LINE_COUNT, MAX_LINE_COUNT));
        }
    }

    public int get() {
        return value;
    }
}
