package ladder.domain.ladder;

import java.util.Objects;

public class PointDTO {
    private boolean haveRight;

    public PointDTO(boolean haveRight) {
        this.haveRight = haveRight;
    }

    public PointDTO(Point point) {
        this(point.isRightDirection());
    }

    public boolean getRight() {
        return haveRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointDTO pointDTO = (PointDTO) o;
        return haveRight == pointDTO.haveRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(haveRight);
    }
}
