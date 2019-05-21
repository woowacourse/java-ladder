package ladder.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Ladder {
    private static final String NEW_LINE = "\n";
    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public Ladder(LadderGamePlayers players, LadderHeight height) {
        List<LadderLine> createdLines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            createdLines.add(new LadderLine(players.size() - 1));
        }
        this.lines = createdLines;
    }

    boolean hasCrossbar(int column, int row) {
        return lines.get(row).hasCrossbar(column);
    }

    int size() {
        return lines.size();
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(LadderLine::toString)
                .collect(joining(NEW_LINE));
    }
}
