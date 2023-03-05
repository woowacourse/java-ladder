package domain.ladder;

import domain.player.Player;
import domain.player.Position;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public List<List<Boolean>> getLadderShape() {
        return lines.stream()
                .map(Line::getRightConnectionCondition)
                .collect(Collectors.toList());
    }

    public Position ride(Player player) {
        Position playerPosition = player.getPosition();

        for (Line line : lines) {
            playerPosition = line.ride(playerPosition);
        }

        return playerPosition;
    }
}
