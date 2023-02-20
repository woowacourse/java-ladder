package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Map<Player, LadderResult> playerWithResult;

    public Calculator(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        playerWithResult = calculateGameResult(players, ladder, ladderResults);
    }

    public Map<Player, LadderResult> calculateGameResult(final Players players, final Ladder ladder, final LadderResults ladderResults) {
        List<Integer> playerResults = new ArrayList<>();
        initPlayerPosition(players, playerResults);

        for (int height = 0; height < ladder.findLadderHeight(); height++) {
            List<Boolean> footholdsOfHeight = findFootholdsOfHeight(ladder, height);
            moveLadder(players, playerResults, footholdsOfHeight);
        }

        return makeGameResult(players, playerResults, ladderResults);
    }

    private void initPlayerPosition(final Players players, final List<Integer> playerResults) {
        for (int i = 0; i < players.findNumberOfPlayers(); i++) {
            playerResults.add(i);
        }
    }

    private void moveLadder(final Players players, final List<Integer> playerResults, final List<Boolean> footholdsOfHeight) {
        for (int index = 0; index < players.findNumberOfPlayers(); index++) {
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

    private void moveAtFirstOfLadder(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight, final int index) {
        if (isExistFootholdAtFirst(footholdsOfHeight)) {
            moveNextIndex(playerResults, index);
        }
    }

    private boolean isExistFootholdAtFirst(final List<Boolean> footholdsOfHeight) {
        return footholdsOfHeight.get(0) == true;
    }

    private void moveEndOfIndex(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight, final int index) {
        if (isExistFootholdEndOfIndex(footholdsOfHeight)) {
            movePrevIndex(playerResults, index);
        }
    }

    private boolean isExistFootholdEndOfIndex(final List<Boolean> footholdsOfHeight) {
        return footholdsOfHeight.get(footholdsOfHeight.size() - 1);
    }

    private void moveBodyOfLadder(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                  final int index) {
        if (isExistFootholdPrevIndex(footholdsOfHeight, playerResults.get(index))) {
            movePrevIndex(playerResults, index);
            return;
        }

        if (isExistFootholdNextIndex(footholdsOfHeight, playerResults.get(index))) {
            moveNextIndex(playerResults, index);
            return;
        }
    }

    private boolean isExistFootholdNextIndex(final List<Boolean> footholdsOfHeight, final int playerIndex) {
        return footholdsOfHeight.get(playerIndex) == true;
    }

    private boolean isExistFootholdPrevIndex(final List<Boolean> footholdsOfHeight, final int playerIndex) {
        return footholdsOfHeight.get(playerIndex - 1) == true;
    }

    private boolean isEndIndexOfLadder(final List<Integer> playerResults, final int index) {
        return playerResults.get(index) == playerResults.size() - 1;
    }

    private void movePrevIndex(final List<Integer> playerResults, final int index) {
        playerResults.set(index, playerResults.get(index) - 1);
    }

    private void moveNextIndex(final List<Integer> playerResults, final int index) {
        playerResults.set(index, playerResults.get(index) + 1);
    }

    private List<Boolean> findFootholdsOfHeight(final Ladder ladder, final int indexOfHeight) {
        return ladder.findLineByIndexOfHeight(indexOfHeight);
    }

    private Map<Player, LadderResult> makeGameResult(final Players players, final List<Integer> playerResults, final LadderResults ladderResults) {
        Map<Player, LadderResult> playerWithLadderResult = new HashMap<>();

        for (int i = 0; i < players.findNumberOfPlayers(); i++) {
            Player player = players.findPlayerByIndex(i);
            LadderResult ladderResult = ladderResults.findLadderResultByIndex(playerResults.get(i));
            playerWithLadderResult.put(player, ladderResult);
        }

        return playerWithLadderResult;
    }

    public String findPlayerResult(final Player player) {
        return this.playerWithResult.get(player).getResult();
    }

    public Map<Player, LadderResult> getPlayerWithResult() {
        return playerWithResult;
    }
}
