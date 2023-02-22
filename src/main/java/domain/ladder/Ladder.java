package domain.ladder;

import domain.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;
    private LadderResults ladderResults;

    public Ladder(List<Line> lines,
                  LadderHeight ladderHeight,
                  LadderResults ladderResults) {
        this.lines = new ArrayList<>(lines);
        this.ladderHeight = ladderHeight;
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
