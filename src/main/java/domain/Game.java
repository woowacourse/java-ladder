package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public Game(final Ladder ladder, final Players players, final LadderResults ladderResults) {
        this.ladder = ladder;
        this.players = players;
        this.ladderResults = ladderResults;
    }

    public void calculatePlayerResults() {
        List<Integer> playerResults = new ArrayList<>();

        initPlayerPosition(playerResults);

        for (int height = 0; height < ladder.findLadderHeight(); height++) {
            moveLadder(playerResults, height);
        }

        addResultToPlayer(playerResults);
    }

    private void initPlayerPosition(final List<Integer> playerResults) {
        for (int i = 0; i < this.players.findNumberOfPlayers(); i++) {
            playerResults.add(i);
        }
    }

    private void moveLadder(final List<Integer> playerResults, final int height) {
        List<Boolean> footholdsOfHeight = findFootholdsOfHeight(height);

        for (int index = 0; index < this.players.findNumberOfPlayers(); index++) {
            moveLine(playerResults, footholdsOfHeight, index);
        }
    }

    private void moveLine(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight, final int index) {
        if (isFirstIndexOfLadder(playerResults.get(index))) {
            moveAtFirstOfLadder(playerResults, footholdsOfHeight, index);
            return;
        }

        if (isEndIndexOfLadder(playerResults, index)) {
            moveEndOfIndex(playerResults, footholdsOfHeight, index);
            return;
        }

        moveBodyOfLadder(playerResults, footholdsOfHeight, index);
    }

    private boolean isFirstIndexOfLadder(final int index) {
        return index == 0;
    }

    private void moveAtFirstOfLadder(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                     final int index) {
        if (isExistFootholdAtFirst(footholdsOfHeight)) {
            moveNextIndex(playerResults, index);
        }
    }

    private boolean isExistFootholdAtFirst(final List<Boolean> footholdsOfHeight) {
        return footholdsOfHeight.get(0) == true;
    }

    private void moveEndOfIndex(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                final int index) {
        if (isExistFootholdEndOfIndex(footholdsOfHeight)) {
            movePrevIndex(playerResults, index);
        }
    }

    private boolean isExistFootholdEndOfIndex(List<Boolean> footholdsOfHeight) {
        return footholdsOfHeight.get(footholdsOfHeight.size() - 1);
    }

    private void moveBodyOfLadder(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                  final int index) {
        if (isExistFootholdPrevIndex(footholdsOfHeight, playerResults.get(index))) {
            movePrevIndex(playerResults, index);
        } else if (isExistFootholdNextIndex(footholdsOfHeight, playerResults.get(index))) {
            moveNextIndex(playerResults, index);
        }
    }

    private boolean isExistFootholdNextIndex(final List<Boolean> footholdsOfHeight, final int playerIndex) {
        return footholdsOfHeight.get(playerIndex) == true;
    }

    private boolean isExistFootholdPrevIndex(final List<Boolean> footholdsOfHeight, final int playerIndex) {
        return footholdsOfHeight.get(playerIndex - 1) == true;
    }

    private void movePrevIndex(final List<Integer> playerResults, final int index) {
        playerResults.set(index, playerResults.get(index) - 1);
    }

    private void moveNextIndex(final List<Integer> playerResults, final int index) {
        playerResults.set(index, playerResults.get(index) + 1);
    }

    private boolean isEndIndexOfLadder(final List<Integer> playerResults, final int index) {
        return playerResults.get(index) == playerResults.size() - 1;
    }

    private List<Boolean> findFootholdsOfHeight(int indexOfHeight) {
        return this.ladder.findLineUsingIndexOfHeight(indexOfHeight);
    }

    private void addResultToPlayer(final List<Integer> playerResults) {
        for (int i = 0; i < this.players.findNumberOfPlayers(); i++) {
            String result = ladderResults.getLadderResultOfIndex(playerResults.get(i));
            this.players.addResult(i, result);
        }
    }
}
