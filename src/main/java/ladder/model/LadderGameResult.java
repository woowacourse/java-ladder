package ladder.model;

import ladder.constant.MessageConstant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private static final int START_VALUE_FOR_RECURSIVE = 0;
    private static final String COLON_WITH_SPACE = " : ";
    private static final String NEW_LINE = "\n";
    private final Ladder ladder;
    private Map<String, String> gameResults = new LinkedHashMap<>();

    public LadderGameResult(final LadderGamePlayers players, final Ladder ladder, final LadderGameGoals goals) {
        this.ladder = ladder;
        initGameResults(players.getAllPlayerNames(), goals.getAllGoalNames());

        generateGameResults(START_VALUE_FOR_RECURSIVE);
    }

    private void initGameResults(List<String> playerNames, List<String> goalNames) {
        for (int i = 0; i < playerNames.size(); i++) {
            gameResults.put(playerNames.get(i), goalNames.get(i));
        }
    }

    private void generateGameResults(int line) {
        if (line == ladder.size()) {
            return;
        }
        generateGameResultsByLine(line, START_VALUE_FOR_RECURSIVE);
        generateGameResults(line + 1);
    }

    private void generateGameResultsByLine(int line, int crossbarIdx) {
        if (crossbarIdx == gameResults.keySet().size() - 1) {
            return;
        }
        swapGoals(line, crossbarIdx);
        generateGameResultsByLine(line, crossbarIdx + 1);
    }

    private void swapGoals(int line, int crossbarIdx) {
        if (ladder.hasCrossbar(crossbarIdx, line)) {
            List<String> keys = getPlayerNames();

            String key = keys.get(crossbarIdx);
            String nextKey = keys.get(crossbarIdx + 1);
            String value = gameResults.get(key);
            gameResults.replace(key, gameResults.get(nextKey));
            gameResults.replace(nextKey, value);
        }
    }

    private List<String> getPlayerNames() {
        return new ArrayList<>(gameResults.keySet());
    }

    public String matchResult(String targetPlayerName) {
        try {
            return matchGoalWith(targetPlayerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String matchGoalWith(String targetPlayerName) {
        if (gameResults.containsKey(targetPlayerName)) {
            return gameResults.get(targetPlayerName);
        }
        throw new IllegalArgumentException(MessageConstant.ERROR_PLAYER_NOT_EXIST);
    }

    @Override
    public String toString() {
        List<String> keys = getPlayerNames();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < gameResults.size(); i++) {
            stringBuilder.append(keys.get(i))
                    .append(COLON_WITH_SPACE)
                    .append(gameResults.get(keys.get(i)))
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
