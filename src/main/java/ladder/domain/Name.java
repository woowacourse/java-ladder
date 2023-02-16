package ladder.domain;

import java.util.Objects;

public class Name {

    //TODO: NAME의 상수 public하는 것이 맞는지

    public static final int NAME_MAXIMUM_LENGTH = 5;
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
            throw new IllegalArgumentException("플레이어의 이름은 1자 이상 5자 이하여야 합니다.");
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
