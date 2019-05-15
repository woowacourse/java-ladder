package ladder.domain;

import ladder.Const;
import ladder.util.Util;

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
        lineStates.add(false);
        for (int i = 1; i < playerCount; i++) {
            lineStates.add(setNextState(lineStates.get(i - 1)));
        }
        return lineStates;
    }

    public boolean isMatchLine(List<Boolean> line) {
        return this.lineStates.equals(line);
    }

    public boolean isMatchLineState(int i) {
        return this.lineStates.get(i);
    }

    public static boolean setNextState(boolean state) {
        if (state) {
            return false;
        }
        return Util.getRandomState();
    }

    private String getStateShape(boolean lineState) {
        if (lineState) {
            return Const.LINE_STATE_TRUE;
        }
        return Const.LINE_STATE_FALSE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Boolean lineState : lineStates) {
            sb.append(getStateShape(lineState));
        }
        return sb.toString();
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
