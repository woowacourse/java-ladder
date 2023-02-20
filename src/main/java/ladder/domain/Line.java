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

    public Players movePlayers(Players players) {
        List<Integer> positions = players.getPositions().stream()
                .map(pos -> pos + directions.get(pos).getMove())
                .collect(Collectors.toList());

        return new Players(players.getPlayerNames(), positions);
    }
}
