package ladder.domain;

public class Height {

    private final int value;

    public Height(String rawValue) {
        int value = parse(rawValue);
        validate(value);
        this.value = value;
    }

    private int parse(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
        }
    }

    public boolean isSame(int value) {
        return this.value == value;
    }
}
