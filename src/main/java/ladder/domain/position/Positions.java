package ladder.domain.position;

import ladder.domain.direction.Direction;
import ladder.domain.line.Line;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private final List<Position> positions;

    public Positions(int width) {
        this.positions = createDefaultPositions(width);
    }

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> createDefaultPositions(int width) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            positions.add(new Position(i));
        }
        return positions;
    }

    public Positions calcPosition(Line line) {
        List<Position> nextPositions = new ArrayList<>();
        List<Direction> directions = line.getDirectionsInfo();
        for(Position position : this.positions) {
            int nowPosition = position.getPosition();
            Direction nowDirection = directions.get(nowPosition);
            nextPositions.add(new Position(calcDirection(nowPosition, nowDirection)));
        }
        return new Positions(nextPositions);
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
