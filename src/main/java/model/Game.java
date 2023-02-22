package model;

import java.util.HashMap;

public class Game {

    private HashMap<Name, Result> prizeResult = new HashMap<>();

    public Game(Names names, LadderResult result, LadderHeight height, Ladder ladder) {
        playGame(names, result, height, ladder);
    }

    private void playGame(Names names, LadderResult result, LadderHeight height, Ladder ladder) {
        for (Name name : names.getNames()) {
            int startIndex = names.getNames().indexOf(name);
            int resultIndex = moveLadder(names.getNamesSize(), height, ladder, startIndex);
            prizeResult.put(name, result.getLadderResult().get(resultIndex));
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
            return column - 1;
        } else if (checkMoveRightLadder(column, row, ladder, personCount)) {
            return column + 1;
        }
        return column;
    }

    private boolean checkMoveLeftLadder(int column, int row, Ladder ladder) {
        return column >= 1 && ladder.getLadder(row).getLine(column - 1);
    }

    private boolean checkMoveRightLadder(int column, int row, Ladder ladder, int personCount) {
        return column < personCount - 1 && ladder.getLadder(row).getLine(column);
    }

    public Result getPrizeIndividualPlayer(Player name) {
        return prizeResult.get(new Name(name.getPlayer()));
    }

    public HashMap<Name,Result> getPrizePlayers() {
        return prizeResult;
    }
}
