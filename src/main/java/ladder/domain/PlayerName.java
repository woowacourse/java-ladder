package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public PlayerName(String name) {
        validateNotNull(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("플레이어의 이름은 null일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어의 이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerName{" +
                "name='" + name + '\'' +
                '}';
    }
}
