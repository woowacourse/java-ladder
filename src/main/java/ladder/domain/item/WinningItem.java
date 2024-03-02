package ladder.domain.item;

import java.util.Objects;

public class WinningItem {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public WinningItem(String name) {
        validate(name);
        this.name = name;
    }

    private static void validateMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("당첨 아이템 이름의 길이는 5자 이하이어야 합니다.");
        }
    }

    private static void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("당첨 아이템의 이름은 비어있거나 공백일 수 없습니다.");
        }
    }

    private void validate(String name) {
        validateMaxLength(name);
        validateIsBlank(name);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WinningItem winningItem)) {
            return false;
        }

        return name.equals(winningItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}

