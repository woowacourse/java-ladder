package ladder.model;

import ladder.validator.LadderGameResultValidator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    private static final int START_VALUE = 0;
    private static final String COLON = " : ";
    private static final String ENTER = "\n";

    private Map<String, String> gameResults = new LinkedHashMap<>();
    private List<String> playerNames;
    private List<String> goalNames;

    public LadderGameResult(LadderGamePlayers players, Ladder ladder, LadderGameGoals goals) {
        this.playerNames = players.getAllPlayerNames();
        this.goalNames = goals.getAllGoalNames();

        initGameResults();

        generateGameResults(ladder, START_VALUE);
    }

    private void initGameResults() {
        for (int i = 0; i < playerNames.size(); i++) {
            gameResults.put(playerNames.get(i), goalNames.get(i));
        }
    }

    private void generateGameResults(Ladder ladder, int line) {
        if (line == ladder.size()) {
            return;
        }
        generateGameResultsByLine(ladder, line, START_VALUE);
        generateGameResults(ladder, line + 1);
    }

    private void generateGameResultsByLine(Ladder ladder, int line, int crossbarIdx) {
        if (crossbarIdx == playerNames.size() - 1) {
            return;
        }
        swapGoals(ladder, line, crossbarIdx);
        generateGameResultsByLine(ladder, line, crossbarIdx + 1);
    }

    private void swapGoals(Ladder ladder, int line, int crossbarIdx) {
        if (ladder.hasCrossbar(crossbarIdx, line)) {
            String value = gameResults.get(playerNames.get(crossbarIdx));
            gameResults.replace(playerNames.get(crossbarIdx), gameResults.get(playerNames.get(crossbarIdx + 1)));
            gameResults.replace(playerNames.get(crossbarIdx + 1), value);
        }
    }

    public String match(String targetPlayer) {
        return LadderGameResultValidator.checMatchPlayerAndGoal(gameResults.get(targetPlayer));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < gameResults.size() ; i++){
            stringBuilder.append(playerNames.get(i)).append(COLON).append(gameResults.get(playerNames.get(i))).append(ENTER);
        }
        return stringBuilder.toString();
    }
}
