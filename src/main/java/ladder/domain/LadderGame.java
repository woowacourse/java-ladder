package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {

    private final Players players;
    private Lines lines;

    public LadderGame(final Players players, final int height) {
        this.players = players;
        initializeLines(height);
    }

    private void initializeLines(final int height) {
        int width = players.size() - 1;
        this.lines = new Lines(height, width);
    }

    public List<Player> toUnmodifiablePlayers() {
        return players.toUnmodifiablePlayers();
    }

    public List<Line> toUnmodifiableLines() {
        return Collections.unmodifiableList(lines.toUnModifiableLines());
    }
}
