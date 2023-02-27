package laddergame.domain;

import laddergame.util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        for (int count = 0; height.isOver(count); count++) {
            Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
