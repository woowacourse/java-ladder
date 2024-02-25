package laddergame.domain.ladder;

import laddergame.domain.player.Players;

public class LineSize {

    private final int lineSize;

    public LineSize(final Players players) {
        this.lineSize = players.getSize() - 1;
    }

    public boolean isBiggerThan(final int size) {
        return lineSize > size;
    }
}
