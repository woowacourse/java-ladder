package laddergame.domain.ladder;

import laddergame.domain.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(final int height, final int numberOfPlayers, final ConnectionStrategy connectionStrategy) {
        validateHeight(height);
        this.lines = createLines(height, numberOfPlayers, connectionStrategy);
    }

    private void validateHeight(final int height) {
        if (height < MIN_HEIGHT) {
            final String heightExceptionMessage = String.format("최소 높이가 %s이상이어야 합니다.", MIN_HEIGHT);
            throw new IllegalArgumentException(heightExceptionMessage);
        }
    }

    private List<Line> createLines(final int height, final int numberOfPlayers, final ConnectionStrategy connectionStrategy) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Line.of(numberOfPlayers, connectionStrategy));
        }

        return lines;
    }

    public boolean canMoveLeft(final int height, final Player player) {
        final int playerPosition = player.getPosition();

        if (playerPosition == 0) {
            return false;
        }

        final Line currentLine = lines.get(height);
        return currentLine.canMoveLeft(playerPosition);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return lines.size();
    }
}
