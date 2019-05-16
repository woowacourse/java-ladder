package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String HEADER_HORIZON_LINE = "   ";
    private static final String VERTICAL_LINE = "|";
    private static final String NEW_LINE = "\n";
    private static final String NO_HORIZON_LINE = "     ";
    private static final String HORIZON_LINE = "-----";
    private static final String HORIZON_DUPLICATION_ERROR = "가로선 중복 오류";

    private List<Boolean> horizon;

    public Line(int playerNumber) {
        horizon = new ArrayList<>();
        makeRandomBooleans(playerNumber);
    }

    public Line(List<Boolean> horizon) {
        checkDuplicateHorizon(horizon);
        this.horizon = horizon;
    }

    public List<Boolean> getHorizon() {
        return this.horizon;
    }

    private void checkDuplicateHorizon(List<Boolean> horizon) {
        for (int i = 0; i < horizon.size(); i++) {
            checkOneDuplicationHorizon(horizon, i);
        }
    }

    private void makeRandomBooleans(int playerNumber) {
        for (int i = 0; i < playerNumber - 1; i++) {
            horizon.add(makeProperBoolean(i));
        }
    }

    private Boolean makeProperBoolean(int currentIndex) {
        Random random = new Random();
        if (currentIndex == 0) {
            return random.nextBoolean();
        }
        if (!this.horizon.get(currentIndex - 1)) {
            return random.nextBoolean();
        }
        return false;
    }

    private void checkOneDuplicationHorizon(List<Boolean> horizon, int i) {
        if (horizon.get(i) && horizon.get(i + 1)) {
            throw new IllegalArgumentException(HORIZON_DUPLICATION_ERROR);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER_HORIZON_LINE);
        for (Boolean bool : this.horizon) {
            sb.append(VERTICAL_LINE);
            sb.append(toStringEachHorLine(bool));
        }
        sb.append(VERTICAL_LINE + NEW_LINE);
        return sb.toString();
    }

    private String toStringEachHorLine(Boolean bool) {
        String result = NO_HORIZON_LINE;
        if (bool) {
            result = HORIZON_LINE;
        }
        return result;
    }

    public int moveRightOrLeft(int playerIndex) {
        if (playerIndex > 0 && this.horizon.get(playerIndex - 1)) {
            return --playerIndex;
        }
        if (playerIndex < horizon.size() && this.horizon.get(playerIndex)) {
            return ++playerIndex;
        }
        return playerIndex;
    }
}
