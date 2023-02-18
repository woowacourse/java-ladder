package domain;

import java.util.List;

public class Game {

    private final Ladder ladder;
    private final Players players;
    private final LadderResults ladderResults;

    public Game(final Ladder ladder, final Players players, final LadderResults ladderResults) {
        this.ladder = ladder;
        this.players = players;
        this.ladderResults = ladderResults;
        this.findPlayerResult();
    }

    public void findPlayerResult() {
        int[] results = new int[this.players.findNumberOfPlayers()];

        initPlayerPosition(results);

        for (int height = 0; height < ladder.findLadderHeight(); height++) {
            moveStepOfLadder(results, height);
        }

        // 데이터 채우기
        for(int i=0; i<players.findNumberOfPlayers(); i++) {
            String result = ladderResults.getLadderResultOfIndex(results[i]);
            players.getPlayers().get(i).addResult(result);
        }
    }

    private void moveStepOfLadder(final int[] players, final int height) {
        List<Boolean> footholdsOfHeight = findFootholdsOfHeight(height);

        for (int index = 0; index < players.length; index++) {
            if (isFirstIndexOfLadder(players[index])) {
                moveAtFirstOfLadder(players, footholdsOfHeight, index);
                continue;
            }

            if (isEndIndexOfLadder(players, index)) {
                moveEndOfIndex(players, footholdsOfHeight, index);
                continue;
            }

            moveBodyOfLadder(players, footholdsOfHeight, index);
        }
    }

    private void moveAtFirstOfLadder(final int[] players, final List<Boolean> footholdsOfHeight, final int index) {
        if (footholdsOfHeight.get(0) == true) {
            moveNextIndex(players, index);
        }
    }

    private void moveBodyOfLadder(final int[] players, final List<Boolean> footholdsOfHeight, final int index) {
        if (isExistFootholdPrevIndex(footholdsOfHeight, players[index])) {
            movePrevIndex(players, index);
        } else if (isExistFootholdNextIndex(footholdsOfHeight, players[index])) {
            moveNextIndex(players, index);
        }
    }

    private void movePrevIndex(final int[] players, final int index) {
        players[index]--;
    }

    private void moveNextIndex(final int[] players, final int index) {
        players[index]++;
    }

    private boolean isExistFootholdNextIndex(final List<Boolean> footholdsOfHeight, final int players) {
        return footholdsOfHeight.get(players) == true;
    }

    private boolean isExistFootholdPrevIndex(final List<Boolean> footholdsOfHeight, final int players) {
        return footholdsOfHeight.get(players - 1) == true;
    }

    private boolean isFirstIndexOfLadder(final int players) {
        return players == 0;
    }

    private boolean isEndIndexOfLadder(final int[] players, final int index) {
        return players[index] == players.length - 1;
    }

    private void moveEndOfIndex(final int[] players, final List<Boolean> footholdsOfHeight, final int index) {
        if (footholdsOfHeight.get(footholdsOfHeight.size() - 1)) {
            movePrevIndex(players, index);
        }
    }

    private void initPlayerPosition(final int[] players) {
        for (int i = 0; i < this.players.findNumberOfPlayers(); i++) {
            players[i] = i;
        }
    }

    private List<Boolean> findFootholdsOfHeight(int indexOfHeight) {
        return this.ladder.findFootholdsOfHeight(indexOfHeight);
    }
}
