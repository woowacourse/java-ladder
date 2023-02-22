package domain.ladder;

import domain.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;
    private List<String> ladderResults;

    public Ladder(List<Line> lines,
                  LadderHeight ladderHeight,
                  List<String> ladderResults) {
        this.lines = new ArrayList<>(lines);
        this.ladderHeight = ladderHeight;
        this.ladderResults = new ArrayList<>(ladderResults);
    }

    public String play(Player player) {
        for (Line line : lines) {
            player.move(line);
        }
        return ladderResults.get(player.getPosition() - 1);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<String> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
