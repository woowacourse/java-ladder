package ladder.domain.ladder;

import java.util.Objects;

public class PointDTO {
    private boolean right;

    public PointDTO(boolean right) {
        this.right = right;
    }

    public PointDTO(Point point) {
        this(point.getRight());
    }

    public boolean getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointDTO pointDTO = (PointDTO) o;
        return right == pointDTO.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(right);
    }
}
