package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(final int height, final int numberOfPlayers) {
        validateNumberOfHeight(height);
        this.lines = createLines(height, numberOfPlayers);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private void validateNumberOfHeight(final int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("최소 높이가 1이상이어야 합니다.");
        }
    }

    private List<Line> createLines(final int height, final int numberOfPlayers) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Line.from(numberOfPlayers));
        }

        return lines;
    }
}
