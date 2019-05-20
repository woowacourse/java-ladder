package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LEN = 5;

    private final String name;

    public Player(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("이름이 null 혹은 빈 문자열입니다.");
        }

        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(
                    String.format("Player.이름은 %d 글자보다 작아야 합니다. 현재길이: %d", MAX_NAME_LEN, name.length()));
        }
        this.name = name;
    }

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
