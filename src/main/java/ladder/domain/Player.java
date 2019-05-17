package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final Position position;

    public Player(String name, Position position) {
        validateNameNull(name);
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateNameNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("플레이어 이름은 null일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름은 " + MIN_NAME_LENGTH  + "이상 " + MAX_NAME_LENGTH + "이하이여야 합니다.");
        }
    }

    public Player move(Direction direction) {
        Position newPosition = new Position(position.getValue() + direction.move());
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
}
