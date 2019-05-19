package ladderGame.domain;

import java.util.*;

public class User {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public User(final String name, final int lineNum) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = lineNum;
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 1자 이상 입력하세요.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw  new IllegalArgumentException("이름이 5자 초과입니다.");
        }
    }

    public int movePosition(int distance) {
        this.position += distance;
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return position == user.position &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
