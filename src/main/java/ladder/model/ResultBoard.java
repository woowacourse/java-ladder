package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class ResultBoard {

    private final Players players;
    private final Ladder ladder;
    private final Rewards rewards;

    public ResultBoard(Players players, Ladder ladder, Rewards rewards){
        this.players = players;
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public Map<Player, Reward> getResult() {
        Map<Player, Reward> result = new HashMap<>();
        for (Player player : players.getPlayers()) {
            result.put(player, getRewardOf(player));
        }
        return result;
    }

    public Reward getRewardOf(Player player) {
        int entrance = players.findPositionOf(player);
        int exit = ladder.findExitFrom(entrance);
        return rewards.getRewards().get(exit);
    }

    public Reward getRewardOf(String playerName) {
        Player player = players.findPlayerByName(playerName);
        return getRewardOf(player);
    }

}
