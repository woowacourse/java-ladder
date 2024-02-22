package domain;

import java.util.Objects;

public class Bridge {
    private final int rail;
    private final int height;

    public Bridge(final int rail, final int height) {
        if (rail < 0 || height < 0) {
            throw new IllegalArgumentException("잘못된 연결을 하면 예외가 발생한다");
        }

        this.rail = rail;
        this.height = height;
    }

    public boolean isAdjacent(Bridge bridge) {
        if (height != bridge.height) {
            return false;
        }

        return rail + 1 == bridge.rail || rail - 1 == bridge.rail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge = (Bridge) o;
        return rail == bridge.rail && height == bridge.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rail, height);
    }
}
