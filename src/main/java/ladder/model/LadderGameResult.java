package ladder.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResult {

    private static final String COLON = " : ";
    private static final String ENTER = "\n";

    private Map<LadderPlayer, LadderGoal> gameResults = new LinkedHashMap<>();

    public LadderGameResult(LadderGamePlayers players, Ladder ladder, LadderGameGoals goals) {
        List<LadderPlayer> changedPlayers = ladder.changePlayer(players.getAllPlayer());
        generateGameResult(goals, changedPlayers);
    }

    private void generateGameResult(LadderGameGoals goals, List<LadderPlayer> changedPlayers) {
        for (int i = 0; i < changedPlayers.size(); i++) {
            gameResults.put(changedPlayers.get(i), goals.getAllGoalNames().get(i));
        }
    }

    public String match(String targetPlayer) {
        return gameResults.keySet()
                .stream()
                .filter(player -> player.getPlayerName().equals(targetPlayer))
                .map(player -> gameResults.get(player).getGoalName())
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        gameResults.keySet()
                .forEach(player -> stringBuilder.append(player.getPlayerName())
                .append(COLON)
                .append(gameResults.get(player).getGoalName())
                .append(ENTER));
        return stringBuilder.toString();
    }
}
