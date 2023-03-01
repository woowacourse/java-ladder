package domain.ladder;

import domain.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public void play(Player player) {
        for (Line line : lines) {
            line.move(player);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
