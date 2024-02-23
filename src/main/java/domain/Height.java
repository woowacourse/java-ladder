package domain;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 20;

    private final int value;

    public Height(String rawValue) {
        validate(rawValue);
        this.value = initialize(rawValue);
    }

    private void validate(String rawValue) {
        validateNonNumeric(rawValue);
        validateRange(Integer.parseInt(rawValue));
    }

    private void validateNonNumeric(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    private void validateRange(int value) {
        if (value < MIN_HEIGHT || value > MAX_HEIGHT) {
            throw new IllegalArgumentException(MIN_HEIGHT + " 이상 " + MAX_HEIGHT + " 이하의 숫자를 입력해 주세요.");
        }
    }

    private int initialize(String rawValue) {
        return Integer.parseInt(rawValue);
    }

    public int getValue() {
        return value;
    }
}
