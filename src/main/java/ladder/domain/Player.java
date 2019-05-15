package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;
    private String name;
    private int position;

    public Player(final String name, final int position) {
        this.name = name.trim();
        validateNameLength();
        this.position = position;
    }

    private void validateNameLength() {
        int nameLength = name.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이내여야 합니다.");
        }
    }

    void goDown(final Line line) {
        position += line.getDirection(position).getValue();
    }

    public String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
