package ladder.domain.participant;

import ladder.domain.ladder.Direction;

import java.util.Objects;

public class Participant {
    private final String name;
    private final Position position;

    public Participant(final String name, final Position position) {
        checkNameLength(name);
        checkForbidName(name);
        this.name = name;
        this.position = position;
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

    public void move(Direction direction) {
        position.move(direction);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name;
    }
}
