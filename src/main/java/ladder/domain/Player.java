package ladder.domain;

import java.util.Objects;

public class Player implements Name {
    public static final int MAX_NAME_LEN = 5;
    public static final Player ALL = Player.from("all");

    private final String name;

    private Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 혹은 비어있습니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LEN + " 자 이하여야 합니다.");
        }
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    @Override
    public String getName() {
        return name;
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
