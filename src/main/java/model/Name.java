package model;

import java.util.Objects;

public abstract class Name {
    private final String name;

    protected Name(final String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract void validateName(final String name);

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name otherName = (Name) o;
        return Objects.equals(name, otherName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
