package ladder.domain;

import java.util.*;

public class HorizontalLine {
    private static final String VALIDATION_FAIL_MESSAGE = "사다리게임에 사용할 수 없는 입력입니다.";
    private static final Random RANDOM = new Random();

    private final List<Direction> directions;

    HorizontalLine(List<Direction> directions) {
        validate(directions);
        this.directions = directions;
    }

    private void validate(List<Direction> directions) {
        Direction preD = Direction.NONE;
        for (Direction d : directions) {
            validateAdjacentDirections(preD, d);
            preD = d;
        }
        if (preD.equals(Direction.RIGHT)) {
            throw new IllegalArgumentException(VALIDATION_FAIL_MESSAGE);
        }
    }

    private void validateAdjacentDirections(Direction prev, Direction current) {
        if (prev.equals(Direction.RIGHT) && !current.equals(Direction.LEFT)) {
            throw new IllegalArgumentException(VALIDATION_FAIL_MESSAGE);
        }
        if (current.equals(Direction.LEFT) && !prev.equals(Direction.RIGHT)) {
            throw new IllegalArgumentException(VALIDATION_FAIL_MESSAGE);
        }
    }

    public static HorizontalLine create(int numPosition) {
        return new HorizontalLine(generateRandomDirections(numPosition));
    }

    private static List<Direction> generateRandomDirections(int numPosition) {
        List<Direction> generatedDirections = new ArrayList<>();
        Direction d = Direction.NONE;
        for (int i = 0; i < numPosition - 1; i++) {
            d = d.next(RANDOM::nextBoolean);
            generatedDirections.add(d);
        }
        generatedDirections.add(d.end());

        return generatedDirections;
    }

    public static HorizontalLine from(List<Direction> directions) {
        return new HorizontalLine(directions);
    }

    public Position nextPosition(Position p) {
        return directionAt(p).nextPosition(p);
    }

    private Direction directionAt(Position p) {
        return directions.get(p.toInt());
    }

    public int getNumPosition() {
        return directions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorizontalLine that = (HorizontalLine) o;
        return Objects.equals(directions, that.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }

    @Override
    public String toString() {
        String empty = "     ";
        String drawn = "-----";
        String bar = "|";

        StringBuilder sb = new StringBuilder();
        for (Direction direction : directions) {
            sb.append(direction.equals(Direction.LEFT) ? drawn : empty);
            sb.append(bar);
        }

        return sb.toString();
    }
}
