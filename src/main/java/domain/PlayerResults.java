package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerResults {

    private final Map<Player, Prize> playerResults;

    private PlayerResults(Map<Player, Prize> playerResults) {
        this.playerResults = playerResults;
    }

    public static PlayerResults of(Players players, Ladder ladder, Prizes prizes) {
        Map<Player, Prize> playerResults = new LinkedHashMap<>();

        for (Player player : players.getPlayers()) {
            String name = player.getName();
            int resultPosition = ladder.playLadderGame(players.findPositionOfPlayer(name));
            playerResults.put(player, prizes.findPrizeByPosition(resultPosition));
        }

        return new PlayerResults(playerResults);
    }

    public Prize findPlayerResultByPlayer(String playerName) {
        Player player = playerResults.keySet().stream()
                .filter(key -> key.getName().equals(playerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("참여자 목록에 없는 이름입니다."));
        return playerResults.get(player);
    }

    public boolean hasResult(String name) {
        return Command.isAllCommand(name) || playerResults.keySet().stream()
                .anyMatch(key -> key.getName().equals(name));
    }

    public Map<Player, Prize> getPlayerResults() {
        return Collections.unmodifiableMap(playerResults);
    }
}
