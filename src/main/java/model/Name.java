package model;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateLength(name);

        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 가능합니다.");
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public boolean matchesByName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof Name)) {
            return false;
        }
        Name targetName = (Name) target;
        return Objects.equals(getName(), targetName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
