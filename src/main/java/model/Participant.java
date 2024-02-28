package model;

import java.util.Objects;

public class Participant {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Participant(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름은 null이거나 공백일 수 없다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름의 길이는 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


