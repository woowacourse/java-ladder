package model;

import java.util.Objects;

public record Prize(String value) {

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
