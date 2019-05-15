package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private String name;

    public PlayerName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("빈 이름 오류");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이 5초과 오류");
        }
        if(name.contains(" ")){
            throw new IllegalArgumentException("이름 공백 포함 오류");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerName)) return false;
        PlayerName that = (PlayerName) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return String.format("%6s",this.name);
    }
}
