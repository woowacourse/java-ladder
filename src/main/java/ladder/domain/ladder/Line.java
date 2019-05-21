package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        this.directions = directions;
    }

    public Direction get(int index) {
        return directions.get(index);
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }

    public int move(int currentLocation) {
        return directions.get(currentLocation).getDirection();
    }
}
