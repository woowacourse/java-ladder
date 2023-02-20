package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {


    private final List<Floor> lines;

    public Ladder(final Height height, final int numberOfPlayers) {
        this.lines = createLines(height.getHeight(), numberOfPlayers);
    }

    public List<Floor> getLadder() {
        return Collections.unmodifiableList(lines);
    }


    private List<Floor> createLines(final int height, final int playerCount) {
        final List<Floor> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Floor.from(playerCount));
        }

        return lines;
    }
}
