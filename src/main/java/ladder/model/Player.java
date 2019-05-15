package ladder.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Player(String name, int position) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("올바르지 않은 이름입니다.");
        }
        this.name = name;
        this.position = position;
    }

    private boolean isValidName(String name) {
        return (!StringUtils.isBlank(name)) && (name.length() <= MAX_NAME_LENGTH);
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
