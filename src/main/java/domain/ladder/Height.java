package domain.ladder;

public class Height {

    private final int intValue;

    public Height(int intValue) {
        validate(intValue);
        this.intValue = intValue;
    }

    private void validate(int intValue) {
        if (intValue <= 0) {
            throw new IllegalArgumentException("높이는 자연수를 입력해주세요.");
        }
    }

    public int getIntValue() {
        return intValue;
    }
}
