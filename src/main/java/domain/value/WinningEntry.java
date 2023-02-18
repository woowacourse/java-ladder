package domain.value;

import java.util.Objects;

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
