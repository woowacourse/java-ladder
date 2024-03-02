package ladder.domain.item;

import java.util.Objects;

public class WinningItem {
    private final String name;

    public WinningItem(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("당첨 아이템의 이름은 비어있거나 공백일 수 없습니다.");
        }
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

