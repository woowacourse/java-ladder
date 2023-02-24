package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        this.directions = directions;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public Players movePlayers(final Players players) {
        final List<Integer> positions = players.getPositions().stream()
                .map(position -> position + nextMove(position))
                .collect(Collectors.toList());

        return new Players(players.getPlayerNames(), positions);
    }

    private int nextMove(Integer pos) {
        return directions.get(pos).getMove();
    }
}
