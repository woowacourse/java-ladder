package ladder.domain.position;

import ladder.domain.direction.Direction;
import ladder.domain.line.Line;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private final List<Position> positions;

    public Positions(List<Position> positions, Line line) {
        this.positions = calcPosition(positions, line);
    }

    public List<Position> calcPosition(List<Position> nowPositions, Line line) {
        List<Position> nextPositions = new ArrayList<>();
        List<Direction> directions = line.getDirectionsInfo();
        for(Position position : nowPositions) {
            int nowPosition = position.getPosition();
            Direction nowDirection = directions.get(nowPosition);
            nextPositions.add(new Position(calcDirection(nowPosition, nowDirection)));
        }
        return nextPositions;
    }

    private int calcDirection(int position, Direction direction) {
        if (direction == Direction.RIGHT) {
            return position + 1;
        }
        if (direction == Direction.LEFT) {
            return position - 1;
        }
        return position;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
