package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int EXCEPT_FIRST_AND_LAST = 2;

    private List<Direction> line;

    public Line(RandomValueGenerator randomValueGenerator, int numberOfVerticalLine) {
        line = new ArrayList<>();

        line.add(firstDirection(randomValueGenerator));
        for (int i = 0; i < numberOfVerticalLine - EXCEPT_FIRST_AND_LAST; i++) {
            line.add(line.get(i).next(randomValueGenerator));
        }
        line.add(lastDirection());
    }

    private Direction firstDirection(RandomValueGenerator randomValueGenerator) {
        return Direction.first(randomValueGenerator);
    }

    private Direction lastDirection() {
        return line.get(line.size() - 1).last();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    public List<Direction> getLine() {
        return line;
    }

    void move(List<Player> players) {
        for (int currentPosition = 0; currentPosition < players.size(); currentPosition++) {
            int nextMoving = line.get(currentPosition).move();
            updateMatchedPlayer(players, currentPosition, nextMoving);
        }
    }

    private void updateMatchedPlayer(List<Player> players, int currentPosition, int nextMoving) {
        for (Player player : players) {
            if (player.isMatchPlayer(currentPosition)) {
                player.updatePosition(nextMoving);
            }
        }
    }
}
