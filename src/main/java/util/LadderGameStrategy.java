package util;

import model.Ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderGameStrategy implements GameStrategy {
    private static final int MOVE_LADDER = 1;
    private final Map<Integer, Integer> prizeResult = new HashMap<>();

    @Override
    public Map<Integer, Integer> playGame(Ladder ladder) {
        int personCount = ladder.getLadderLineSize(0) + 1;
        for (int i = 0; i < personCount; i++) {
            int startPlayerIndex = i;
            int resultIndex = moveLadder(personCount, ladder.getLadderSize(),
                    ladder,
                    startPlayerIndex);
            prizeResult.put(startPlayerIndex, resultIndex);
        }
        return prizeResult;
    }

    private int moveLadder(int personCount, int height, Ladder ladder, int column) {
        for (int row = 0; row < height; row++) {
            column = moveSideLadder(column, row, ladder, personCount);
        }
        return column;
    }

    private int moveSideLadder(int column, int row, Ladder ladder, int personCount) {
        if (checkMoveLeftLadder(column, row, ladder)) {
            return column - MOVE_LADDER;
        } else if (checkMoveRightLadder(column, row, ladder, personCount)) {
            return column + MOVE_LADDER;
        }
        return column;
    }

    private boolean checkMoveLeftLadder(int column, int row, Ladder ladder) {
        int leftLadderLine = column - 1;
        return column >= 1 && ladder.existLadderLine(leftLadderLine, row);
    }

    private boolean checkMoveRightLadder(int column, int row, Ladder ladder, int personCount) {
        int ladderLineNum = personCount - 1;
        return column < ladderLineNum && ladder.existLadderLine(column, row);
    }
}
