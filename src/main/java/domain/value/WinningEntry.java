package domain.value;

public class WinningEntry {

    private final String value;

    public WinningEntry(final String value) {
        validateEmpty(value);
        this.value = value;
    }

    private void validateEmpty(final String value) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("당첨 항목은 1글자 이상이어야 합니다.");
        }
    }

    public String value() {
        return value;
    }
}
