package domain.value;

import java.util.Objects;

public class WinningEntry {

    private static final int MIN_LENGTH_INCLUSIVE = 1;
    private static final int MAX_LENGTH_INCLUSIVE = 5;

    private final String value;

    public WinningEntry(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        validateSize(value);
    }

    private void validateSize(final String value) {
        if (MIN_LENGTH_INCLUSIVE > value.length() || value.length() > MAX_LENGTH_INCLUSIVE) {
            throw new IllegalArgumentException(String.format("당첨 항목은 %d글자 이상, %d글자 미만이어야 합니다.",
                    MIN_LENGTH_INCLUSIVE,
                    MAX_LENGTH_INCLUSIVE));
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningEntry)) return false;
        WinningEntry that = (WinningEntry) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
