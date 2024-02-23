package domain;

import java.util.Objects;

class Name {
    static final int MAX_NAME_LENGTH = 5;
    private final String name;

    Name(String name) {
        validateNameLength(name);
        validateNameCharacters(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name other = (Name) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    String getName() {
        return name;
    }

    private void validateNameCharacters(String name) {
        if (name.matches("^[^a-zA-Z]+$")) {
            throw new LadderGameException(ExceptionType.NAME_CHARACTER);
        }
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new LadderGameException(ExceptionType.NAME_LENGTH_RANGE);
        }
    }
}
