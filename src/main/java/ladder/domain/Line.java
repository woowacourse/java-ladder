package ladder.domain;

import java.util.List;

public class Line {
    private final List<Direction> directionsInfo;

    public Line(List<Direction> directionsInfo) {
        this.directionsInfo = directionsInfo;
    }

    public List<Direction> getDirectionsInfo() {
        return directionsInfo;
    }
}
