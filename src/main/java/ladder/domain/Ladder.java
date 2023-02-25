package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ladder.domain.generator.LineGenerator;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final LineGenerator lineGenerator, final Players players, final Height height) {
        this.lines = generateLines(lineGenerator, players, height);
    }

    private List<Line> generateLines(final LineGenerator lineGenerator, final Players players, final Height height) {
        final List<Line> lines = new ArrayList<>();
        final int directionCount = players.numberOfPlayers();

        for (int i = 0; i < height.getValue(); i++) {
            lines.add(lineGenerator.generate(directionCount));
        }

        return lines;
    }

    public Players movePlayers(Players players) {
        for (final Line line : lines) {
            players = players.move(line);
        }

        return players;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
