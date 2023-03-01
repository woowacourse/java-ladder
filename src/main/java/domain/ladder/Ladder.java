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
            move(player, line);
        }
    }

    private void move(Player player, Line line) {
        if (line.isLeftSidePassable(player)) {
            player.moveLeft();
            return;
        }

        if (line.isRightSidePassable(player)) {
            player.moveRight();
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
