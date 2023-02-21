package utils;

import domain.GameResultCalculator;
import domain.Ladder;
import domain.LadderResult;
import domain.LadderResults;
import domain.Player;
import domain.Players;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameResultCalculatorFactory {

    public static GameResultCalculator createGameResultCalculator(final Players players, final Ladder ladder,
                                                                  final LadderResults ladderResults) {
        Map<Player, LadderResult> playerWithResult = calculateGameResult(players, ladder, ladderResults);
        return new GameResultCalculator(playerWithResult);
    }

    public static Map<Player, LadderResult> calculateGameResult(final Players players, final Ladder ladder,
                                                                final LadderResults ladderResults) {
        List<Integer> playerResults = new ArrayList<>();
        initPlayerPosition(players, playerResults);

        for (int height = 0; height < ladder.findLadderHeight(); height++) {
            List<Boolean> footholdsOfHeight = findFootholdsOfHeight(ladder, height);
            moveLadder(players, playerResults, footholdsOfHeight);
        }

        return makeGameResult(players, playerResults, ladderResults);
    }

    private static void initPlayerPosition(final Players players, final List<Integer> playerResults) {
        for (int i = 0; i < players.findNumberOfPlayers(); i++) {
            playerResults.add(i);
        }
    }

    private static void moveLadder(final Players players, final List<Integer> playerResults,
                                   final List<Boolean> footholdsOfHeight) {
        for (int index = 0; index < players.findNumberOfPlayers(); index++) {
            moveLine(playerResults, footholdsOfHeight, index);
        }
    }

    private static void moveLine(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                 final int index) {
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

    private static boolean isFirstIndexOfLadder(final int index) {
        return index == 0;
    }

    private static void moveAtFirstOfLadder(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                            final int index) {
        if (isExistFootholdAtFirst(footholdsOfHeight)) {
            moveNextIndex(playerResults, index);
        }
    }

    private static boolean isExistFootholdAtFirst(final List<Boolean> footholdsOfHeight) {
        return footholdsOfHeight.get(0) == true;
    }

    private static void moveEndOfIndex(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
                                       final int index) {
        if (isExistFootholdEndOfIndex(footholdsOfHeight)) {
            movePrevIndex(playerResults, index);
        }
    }

    private static boolean isExistFootholdEndOfIndex(final List<Boolean> footholdsOfHeight) {
        return footholdsOfHeight.get(footholdsOfHeight.size() - 1);
    }

    private static void moveBodyOfLadder(final List<Integer> playerResults, final List<Boolean> footholdsOfHeight,
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

    private static boolean isExistFootholdNextIndex(final List<Boolean> footholdsOfHeight, final int playerIndex) {
        return footholdsOfHeight.get(playerIndex) == true;
    }

    private static boolean isExistFootholdPrevIndex(final List<Boolean> footholdsOfHeight, final int playerIndex) {
        return footholdsOfHeight.get(playerIndex - 1) == true;
    }

    private static boolean isEndIndexOfLadder(final List<Integer> playerResults, final int index) {
        return playerResults.get(index) == playerResults.size() - 1;
    }

    private static void movePrevIndex(final List<Integer> playerResults, final int index) {
        playerResults.set(index, playerResults.get(index) - 1);
    }

    private static void moveNextIndex(final List<Integer> playerResults, final int index) {
        playerResults.set(index, playerResults.get(index) + 1);
    }

    private static List<Boolean> findFootholdsOfHeight(final Ladder ladder, final int indexOfHeight) {
        return ladder.findLineByIndexOfHeight(indexOfHeight);
    }

    private static Map<Player, LadderResult> makeGameResult(final Players players, final List<Integer> playerResults,
                                                            final LadderResults ladderResults) {
        Map<Player, LadderResult> playerWithLadderResult = new LinkedHashMap<>();

        for (int i = 0; i < players.findNumberOfPlayers(); i++) {
            Player player = players.findPlayerByIndex(i);
            LadderResult ladderResult = ladderResults.findLadderResultByIndex(playerResults.get(i));
            playerWithLadderResult.put(player, ladderResult);
        }

        return playerWithLadderResult;
    }
}
