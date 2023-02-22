package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(final Height height, final int numberOfPlayers) {
        this.height = height;
        this.lines = createLadder(numberOfPlayers);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }


    private List<Line> createLadder(final int playerCount) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(Line.from(playerCount));
        }

        return lines;
    }
}
