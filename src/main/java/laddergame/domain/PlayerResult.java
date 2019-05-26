package laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayerResult {
    private final List<Player> players;

    public PlayerResult(final List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            playLine(line);
        }
    }

    private void playLine(Line line) {
        for (int i = 0; i < line.getWidth(); i++) {
            swap(line, i);
        }
    }

    private void swap(Line line, int i) {
        if (line.getHandle(i)) {
            Collections.swap(players, i, i + 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerResult that = (PlayerResult) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
