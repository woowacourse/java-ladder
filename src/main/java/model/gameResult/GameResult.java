package model.gameResult;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class GameResult {
    private static final String NOT_EXIST_PLAYER_NAME = "존재하지 않는 참가자입니다.";

    private final ConcurrentHashMap<Player, Prize> result;

    public GameResult(ConcurrentHashMap<Player, Prize> result) {
        this.result = result;
    }

    public static GameResult of(List<Integer> positions, Players players, Prizes prizes) {
        ConcurrentHashMap<Player, Prize> result = new ConcurrentHashMap<>();
        for (int start = 0; start < positions.size(); start++) {
            int end = positions.get(start);
            result.put(players.findPlayer(start), prizes.findPrize(end));
        }
        return new GameResult(result);
    }

    public Prize findPrizeByPlayerName(String playerName) {
        Player player = findPlayerByName(playerName);
        return result.get(player);
    }

    private Player findPlayerByName(String playerName) {
        return result.keySet()
                .stream()
                .filter(player -> player.isNameEqual(playerName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PLAYER_NAME));
    }

    public Prize findPrizeByPlayer(Player player) {
        return result.get(player);
    }

    public List<Player> getPlayers() {
        return result.keySet()
                .stream()
                .toList();
    }
}
