package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {

    private final Players players;
    private Lines lines;

    public LadderGame(Players players, int height) {
        initializeLines(height);
        this.players = players;
    }

    private void initializeLines(int height) {
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
