package ladder.domain.ladder;

import java.util.List;
import ladder.domain.direction.Direction;

public class Line {
    private final List<Direction> directionsInfo;

    public Line(List<Direction> directionsInfo) {
        this.directionsInfo = directionsInfo;
    }

    public List<Direction> getDirectionsInfo() {
        return directionsInfo;
    }
}
