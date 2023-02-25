package domain.ladder;

import domain.player.Players;
import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private static final int FIRST_INDEX = 0;

    private Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public static Ladder generate(Players players, Height height, TrueOrFalseGenerator trueOrFalseGenerator) {
        List<Line> lines = new ArrayList<>();
        int count = FIRST_INDEX;
        while (!height.isSameHeight(count)) {
            Line line = Line.generate(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
            count++;
        }
        return new Ladder(Collections.unmodifiableList(lines));
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
