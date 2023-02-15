package ladder.domain;

import java.util.Objects;

public class StartPoint {
    private final int position;

    public StartPoint(int position) {
        validateNegativePosition(position);
        this.position = position;
    }

    private void validateNegativePosition(int position) {
        if(position < 0) {
            throw new IllegalStateException("플레이어의 시작 위치는 0 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StartPoint that = (StartPoint) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
