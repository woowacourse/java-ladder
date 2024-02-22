package domain;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 20;

    private final int value;

    public Height(String rawValue) {
        this.value = validateNonNumeric(rawValue);
        validateRange(value);
    }

    // TODO: 변환과 검증 분리
    private int validateNonNumeric(String rawValue) {
        try {
            return Integer.parseInt(rawValue); // TODO: 얘를 분리하고 싶다
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
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
