package ladder.domain;

import java.util.Objects;

public class Player {
    private static int MAX_LENGTH = 5;

    private String name;

    public Player(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        checkBlankOrNull(name);
        checkWrongLength(name);
    }

    private void checkBlankOrNull(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkWrongLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
