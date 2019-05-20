package ladder.domain;

import java.util.*;

public class LadderItem {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;

    private final String name;

    public String getName() {
        return name;
    }

    LadderItem(final String name) {
        nullCheck(name);
        this.name = getTrimmed(name);
    }

    private void nullCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름에는 null이 입력될 수 없습니다.");
        }
    }

    private String getTrimmed(String name) {
        name = name.trim();
        validateNameLength(name);
        return name;
    }

    private void validateNameLength(String name) {
        if ((name.length() > MAXIMUM_NAME_LENGTH) || (name.length() < MINIMUM_NAME_LENGTH)) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderItem that = (LadderItem) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
