package ladder;

import java.util.Objects;

public class Participant {
    private final String name;

    public Participant(final String name) {
        checkNameLength(name);
        checkForbidName(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 5자 이하여야합니다.");
        }
    }

    private void checkForbidName(String name) {
        if (name.toLowerCase().equals("all")) {
            throw new IllegalArgumentException("참가자 이름은 all 이 될 수 없습니다.");
        }
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

    @Override
    public String toString() {
        return name;
    }
}
