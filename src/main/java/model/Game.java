package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final int MOVE_LADDER = 1;
    private final Map<Name, Result> prizeResult = new HashMap<>();

    public Game(Names names, LadderResult result, LadderHeight height, Ladder ladder) {
        playGame(names, result, height, ladder);
    }

    private void playGame(Names names, LadderResult result, LadderHeight height, Ladder ladder) {
        for (Name name : names.getNames()) {
            int startPlayerIndex = names.getNames().indexOf(name);
            int resultIndex = moveLadder(names.getNamesSize(), height, ladder, startPlayerIndex);
            prizeResult.put(name, result.getLadderResultElement(resultIndex));
        }
    }

    private int moveLadder(int personCount, LadderHeight height, Ladder ladder, int column) {
        for (int row = 0; row < height.getLadderHeight(); row++) {
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
        return column >= 1 && ladder.getLadderLine(leftLadderLine, row);
    }

    private boolean checkMoveRightLadder(int column, int row, Ladder ladder, int personCount) {
        int ladderLineNum = personCount -1;
        return column < ladderLineNum && ladder.getLadderLine(column,row);
    }

    public String getPrizeIndividualPlayer(Player name) {
        return prizeResult.get(new Name(name.getPlayer())).getResult();
    }

    public Map<Name,Result> getPrizePlayers() {
        return Collections.unmodifiableMap(prizeResult);
    }
}
