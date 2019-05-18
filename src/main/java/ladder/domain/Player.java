package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(PlayerName name, Position position) {
        validateNotNull(position);
        validateNotNull(name);
        this.name = name;
        this.position = position;
    }

    private void validateNotNull(PlayerName name) {
        if (name == null) {
            throw new IllegalArgumentException("플레이어 이름은 null일 수 없습니다.");
        }
    }

    private void validateNotNull(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("플레이어 위치는 null일 수 없습니다.");
        }
    }

    public Player moveOn(Line line) {
        Point point = line.getPoint(position);
        Position newPosition = new Position(position.getValue() + point.move());
        return new Player(name, newPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
