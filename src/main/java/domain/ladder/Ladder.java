package domain.ladder;

import domain.player.Player;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> liens) {
        this.lines = liens;
    }

    public List<List<Boolean>> getLadderShape() {
        return lines.stream()
                .map(Line::getRightConnectionCondition)
                .collect(Collectors.toList());
    }

    public void ride(Player player) {
        for (Line line : lines) {
            line.ride(player);
        }
    }
}
