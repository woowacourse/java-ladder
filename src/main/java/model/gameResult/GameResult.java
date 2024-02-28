package model.gameResult;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class GameResult {
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

    public Prize findPrizeByPlayer(Player player) {
        return result.get(player);
    }
}
