package ladder.domain;

import java.util.*;

public class HorizontalLine {
    private final List<Direction> directions;

    private HorizontalLine(List<Direction> directions) {
        this.directions = directions;
    }

    public static HorizontalLine create(int numPosition) {
        return new HorizontalLine(generateRandomDirections(numPosition));
    }

    public static HorizontalLine create(List<Direction> directions) {
        return new HorizontalLine(directions);
    }

    public Position nextPosition(Position p) {
        return directionAt(p).nextPosition(p);
    }

    private Direction directionAt(Position p) {
        return directions.get(p.toInt());
    }

    private static List<Direction> generateRandomDirections(int numPosition) {
        List<Direction> generatedDirections = new ArrayList<>();
        Direction d = Direction.NONE;
        for (int i = 0; i < numPosition - 1; i++) {
            d = d.next();
            generatedDirections.add(d);
        }
        generatedDirections.add(d.end());

        return generatedDirections;
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
