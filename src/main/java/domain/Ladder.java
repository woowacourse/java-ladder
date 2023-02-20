package domain;

import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        do {
            int count = height.getHeight();
            while (count-- > 0) {
                Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
                lines.add(line);
            }
        }
        while (!validate(height.getHeight()));
    }

    public boolean validate(int height) {
        HashMap<Integer, Integer> falseIndexCountmap = new HashMap<>();
        lines.forEach(line -> line.checkFalseIndex(falseIndexCountmap));
        if (falseIndexCountmap.containsValue(height)) {
            return false;
        }
        return true;
    }

    public List<Line> getLines() {
        return lines;
    }
}
