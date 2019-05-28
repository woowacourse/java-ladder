package ladder.domain;

import java.util.Objects;

public class Reward implements Name {
    public static final int MAX_NAME_LEN = 5;
    private final String name;

    private Reward(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 혹은 비어있습니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LEN + " 자 이하여야 합니다.");
        }
        this.name = name;
    }

    public static Reward from(String name) {
        return new Reward(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
