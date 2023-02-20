package laddergame.domain;

import laddergame.util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        do {
            lines.clear();
            int count = height.getHeight();
            while (count-- > 0) {
                Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
                lines.add(line);
            }
        }
        while (!validate(height.getHeight()));
    }

    private boolean validate(int height) {
        HashMap<Integer, Integer> falseIndexCountmap = new HashMap<>();
        for (Line line : lines) {
            falseIndexCountmap = line.checkFalseIndex(falseIndexCountmap);
        }
        if (falseIndexCountmap.containsValue(height)) {
            return false;
        }
        return true;
    }

    public List<Line> getLines() {
        return lines;
    }
}
