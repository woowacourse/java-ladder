package ladder.domain;

import java.util.Objects;

public class WinningItem {
    private final String name;

    public WinningItem(String name) {
        this.name = name;
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

