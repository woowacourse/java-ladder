package ladder.domain.resource.line;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.Direction;

public class Line {

    private final List<Direction> directionsInfo;

    Line() {
        this.directionsInfo = new ArrayList<>();
    }

    void addDirection(Direction direction) {
        directionsInfo.add(direction);
    }

    public Direction getLastDirection() {
        return directionsInfo.get(directionsInfo.size() - 1);
    }

    public int getLineSize() {
        return directionsInfo.size();
    }

    public List<Direction> getDirectionsInfo() {
        return directionsInfo;
    }
}
