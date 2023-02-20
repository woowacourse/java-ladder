package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    private final List<Floor> lines;

    public Ladder(final int height, final int numberOfPlayers) {
        validateNumberOfHeight(height);
        this.lines = createLines(height, numberOfPlayers);
    }

    public List<Floor> getLadder() {
        return Collections.unmodifiableList(lines);
    }

    private void validateNumberOfHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("최소 높이가 %d이상이어야 합니다.", MIN_HEIGHT));
        }
    }

    private List<Floor> createLines(final int height, final int playerCount) {
        final List<Floor> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Floor.from(playerCount));
        }

        return lines;
    }
}
