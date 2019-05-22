package ladder.model;

import java.util.Map;

public class GameResult {
    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = " : ";
    private Map<Player, LadderGameResult> gameResult;

    GameResult(Map<Player, LadderGameResult> gameResult) {
        this.gameResult = gameResult;
    }

    public String getResultByName(Players players, String name) {
        if (!players.isContains(name)) {
            throw new IllegalArgumentException("없는 이름의 플레이어 입니다.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(name)
                .append(DELIMITER)
                .append(this.gameResult.get(players.getPlayerByName(name)))
                .toString();
    }

    public String getAllResult(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        players.forEach(player -> stringBuilder.append(getResultByName(players, player.getName())).append(NEW_LINE));
        return stringBuilder.toString();
    }
}
