package ladder.domain.position;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;

public class Positions {

    private final List<Position> positions;

    public Positions(int width) {
        this.positions = createDefaultPositions(width);
    }

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    private List<Position> createDefaultPositions(int width) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            positions.add(new Position(i));
        }
        return positions;
    }

    public Positions calculateFinalPositions(Ladder ladder, Positions defaultPositions) {
        List<Line> lines = ladder.getLines();
        Positions nowPositions = defaultPositions;
        for (Line line : lines) {
            nowPositions = nowPositions.calculatePosition(line);
        }
        return nowPositions;
    }

    public Positions calculatePosition(Line line) {
        List<Position> nextPositions = new ArrayList<>();
        List<Direction> directions = line.getDirectionsInfo();
        for (Position position : this.positions) {
            int nowPosition = position.position();
            Direction nowDirection = directions.get(nowPosition);
            nextPositions.add(new Position(calculateDirection(nowPosition, nowDirection)));
        }
        return new Positions(nextPositions);
    }

    private int calculateDirection(int position, Direction direction) {
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
