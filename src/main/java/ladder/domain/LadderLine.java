package ladder.domain;

import ladder.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final int playerCount;
    private List<Boolean> lineStates;

    public LadderLine(int playerCount) {
        this.playerCount = checkCount(playerCount);
        this.lineStates = new ArrayList<>();
        this.lineStates = setLineStates();
    }

    private int checkCount(int playerCount) {
        if (playerCount < Const.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(Const.EX_PLAYER_COUNT);
        }
        return playerCount;
    }

    private List<Boolean> setLineStates() {
        List<Boolean> lineStates = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            lineStates.add(true);
        }
        return lineStates;
    }

    public boolean isMatchLine(List<Boolean> line) {
        return this.lineStates.equals(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return playerCount == that.playerCount &&
                Objects.equals(lineStates, that.lineStates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerCount, lineStates);
    }
}
