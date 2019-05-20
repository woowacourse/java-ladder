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
        List<LadderPlayer> players1 = ladder.changePlayer(players.getAllPlayer());
        for (int i = 0; i < players1.size(); i++) {
            gameResults.put(players1.get(i), goals.getAllGoalNames().get(i));
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
