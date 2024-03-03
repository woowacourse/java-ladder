package ladder.domain;

import java.util.Objects;

public class Name {

    static final String ALL = "all";

    final String value;

    public Name(String value) {
        this.value = value.trim();
    }

    public boolean isAll() {
        return ALL.equals(value);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that instanceof Name name) {
            return Objects.equals(this.value, name.value);
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
