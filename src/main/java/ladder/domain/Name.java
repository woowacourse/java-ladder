package ladder.domain;

import java.util.Objects;

public class Name {

    public static final int NAME_MAXIMUM_LENGTH = 5;
    public static final String ERROR_LENGTH_OF_NAME = String.format(
            "플레이어의 이름은 %d자 이하여야 합니다.", NAME_MAXIMUM_LENGTH);
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
