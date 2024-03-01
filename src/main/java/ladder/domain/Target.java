package ladder.domain;

import java.util.Objects;

public class Target {

    static final String ALL = "all";

    private final String value;

    public Target(String value) {
        this.value = value.trim();
    }

    public boolean isAll() {
        return ALL.equals(value);
    }

    public int getLength() {
        return value.length();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that instanceof Target target) {
            return Objects.equals(this.value, target.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
