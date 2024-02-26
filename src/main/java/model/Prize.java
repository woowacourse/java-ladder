package model;

import java.util.Objects;

//TODO: recode 고민해보기
public class Prize {

    private final String value;

    public Prize(final String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Prize prize)) {
            return false;
        }
        return Objects.equals(value, prize.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
