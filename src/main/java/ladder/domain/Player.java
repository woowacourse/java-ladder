package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public Player(final String name) {
        vaildateNameLength(name.trim());
        this.name = name.trim();
    }

    private void vaildateNameLength(String name) {
        if(name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
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
