package domain;

import java.util.Objects;

public class Bridge {

    private final int from;
    private final int to;
    private final int height;

    // TODO: 속성 이름 수정 필요
    public Bridge(int from, int to, int height) {
        if (from == to) {
            throw new IllegalArgumentException("잘못된 연결을 하면 예외가 발생한다");
        }

        if(from < 0 || to < 0 || height < 0) {
            throw new IllegalArgumentException("잘못된 연결을 하면 예외가 발생한다");
        }

        if (from + 1 != to) {
            throw new IllegalArgumentException("잘못된 연결을 하면 예외가 발생한다");
        }

        this.from = from;
        this.to = to;
        this.height = height;
    }

    public boolean isAdjacent(Bridge bridge) {
        if (height != bridge.height) {
            return false;
        }

        return to == bridge.from || from == bridge.to;
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
        return from == bridge.from && to == bridge.to && height == bridge.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, height);
    }
}
