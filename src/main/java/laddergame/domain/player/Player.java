package laddergame.domain.player;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Player {
    private static final int BOUND_OF_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름에 공백을 입력하지마세요");
        }
        if (name.length() > BOUND_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 5자 초과했습니다");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player that = (Player) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
