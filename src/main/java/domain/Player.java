package domain;

import java.util.Objects;

public class Player {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    public static final String INVALID_NAME = "all";

    private final String name;
    private final Column column;

    public Player(String name, int column) {
        validateNameLength(name);
        validateName(name);
        this.name = name;
        this.column = new Column(column);
    }

    public Player(String name) {
        this(name, 0);
    }

    public Player(Player player) {
        this.name = player.getName();
        this.column = player.getColumn();
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("이름은 %d자 이상 %d자 이하여야 합니다.", MIN_LENGTH, MAX_LENGTH));
        }
    }

    private void validateName(String name) {
        if (name.equals(INVALID_NAME)) {
            throw new IllegalArgumentException(String.format("이름은 %s이 될 수 없습니다.", INVALID_NAME));
        }
    }

    public String getName() {
        return name;
    }

    public Column getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
