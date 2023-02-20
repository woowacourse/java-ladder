package domain;

import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        int count = height.getHeight();
        while (count-- > 0) {
            Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
