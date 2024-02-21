package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(LadderHeight height, Players players, BridgesGenerator bridgesGenerator) {
        int bridgeCount = players.getSizeOfPlayers() - 1;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            Line line = new Line(bridgesGenerator.pickBridges(bridgeCount));
            lines.add(line);
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
