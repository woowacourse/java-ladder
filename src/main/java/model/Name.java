package model;

import java.util.Objects;

public abstract class Name {
    private final String value;

    protected Name(final String rawName) {
        validateName(rawName);
        this.value = rawName;
    }

    protected abstract void validateName(final String rawName);

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name otherName = (Name) o;
        return Objects.equals(value, otherName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getName() {
        return value;
    }
}
