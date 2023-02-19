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

    public void calculateResultOfPlayer() {
        List<Integer> players = new ArrayList<>();

        initPlayerPosition(players);

        for (int height = 0; height < ladder.findLadderHeight(); height++) {
            moveLadder(players, height);
        }

        addResultToPlayer(players);
    }

    private void initPlayerPosition(final List<Integer> players) {
        for (int i = 0; i < this.players.findNumberOfPlayers(); i++) {
            players.add(i);
        }
    }

    private void moveLadder(final List<Integer> players, final int height) {
        List<Boolean> footholdsOfHeight = findFootholdsOfHeight(height);

        for (int index = 0; index < this.players.findNumberOfPlayers(); index++) {
            moveLine(players, footholdsOfHeight, index);
        }
    }

    private void moveLine(final List<Integer> players, final List<Boolean> footholdsOfHeight, final int index) {
        if (isFirstIndexOfLadder(players.get(index))) {
            moveAtFirstOfLadder(players, footholdsOfHeight, index);
            return;
        }

        if (isEndIndexOfLadder(players, index)) {
            moveEndOfIndex(players, footholdsOfHeight, index);
            return;
        }

        moveBodyOfLadder(players, footholdsOfHeight, index);
    }

    private boolean isFirstIndexOfLadder(final int index) {
        return index == 0;
    }

    private void moveAtFirstOfLadder(final List<Integer> players, final List<Boolean> footholdsOfHeight,
                                     final int index) {
        if (footholdsOfHeight.get(0) == true) {
            moveNextIndex(players, index);
        }
    }

    private void moveEndOfIndex(final List<Integer> players, final List<Boolean> footholdsOfHeight, final int index) {
        if (footholdsOfHeight.get(footholdsOfHeight.size() - 1)) {
            movePrevIndex(players, index);
        }
    }

    private void moveBodyOfLadder(final List<Integer> players, final List<Boolean> footholdsOfHeight, final int index) {
        if (isExistFootholdPrevIndex(footholdsOfHeight, players.get(index))) {
            movePrevIndex(players, index);
        } else if (isExistFootholdNextIndex(footholdsOfHeight, players.get(index))) {
            moveNextIndex(players, index);
        }
    }

    private boolean isExistFootholdNextIndex(final List<Boolean> footholdsOfHeight, final int players) {
        return footholdsOfHeight.get(players) == true;
    }

    private boolean isExistFootholdPrevIndex(final List<Boolean> footholdsOfHeight, final int players) {
        return footholdsOfHeight.get(players - 1) == true;
    }

    private void movePrevIndex(final List<Integer> players, final int index) {
        players.set(index, players.get(index) - 1);
    }

    private void moveNextIndex(final List<Integer> players, final int index) {
        players.set(index, players.get(index) + 1);
    }

    private boolean isEndIndexOfLadder(final List<Integer> players, final int index) {
        return players.get(index) == players.size() - 1;
    }

    private void addResultToPlayer(final List<Integer> players) {
        for (int i = 0; i < this.players.findNumberOfPlayers(); i++) {
            String result = ladderResults.getLadderResultOfIndex(players.get(i));
            this.players.getPlayers().get(i).addResult(result);
        }
    }

    private List<Boolean> findFootholdsOfHeight(int indexOfHeight) {
        return this.ladder.findLineUsingIndexOfHeight(indexOfHeight);
    }
}
