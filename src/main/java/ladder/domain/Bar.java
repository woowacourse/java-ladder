package ladder.domain;

import java.util.Objects;

public class Bar {

    private final boolean value;

    public Bar(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return value == bar.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
