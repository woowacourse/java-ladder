package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.direction.Direction;

public class Line {

    private final List<Direction> directionsInfo;

    Line() {
        this.directionsInfo = new ArrayList<>();
    }

    public void addDirection(Direction direction) {
        directionsInfo.add(direction);
    }

    public Direction getLastDirection() {
        return directionsInfo.get(directionsInfo.size() - 1);
    }

    public List<Direction> getDirectionsInfo() {
        return directionsInfo;
    }
}
