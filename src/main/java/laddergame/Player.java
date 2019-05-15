package laddergame;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Player {

    private final String name;

    public Player(String name) {
        checkName(name);
        checkBlank(name);
        this.name = name;
    }

    private static void checkBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름에 공백을 입력하지마세요");
        }
    }

    private void checkName(String name) {
        if (name.length() > Constant.BOUND_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 5자 초과했습니다");
        }
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
