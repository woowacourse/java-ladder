package domain.ladder;

import domain.player.Player;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderResults ladderResults;

    public Ladder(List<Line> lines, LadderResults ladderResults) {
        this.lines = lines;
        this.ladderResults = ladderResults;
    }

    public LadderResult play(Player player) {
        for (Line line : lines) {
            player.move(line);
        }
        return ladderResults.findResultByPosition(player.getPosition());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }
}
