package domain;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 20;

    private final int value;

    public Height(String rawValue) {
        int value = StringParser.stringToInt(rawValue);
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MIN_HEIGHT || value > MAX_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT + " 이상 " + MAX_HEIGHT + " 이하의 숫자를 입력해 주세요.");
        }
    }

    public int getValue() {
        return value;
    }
}
