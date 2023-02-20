package domain;

import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        while (height.isPossibleCount()) {
            Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
            height.minusHeight();
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
