package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private static final String NOT_EXIST_PLAYER_NAME_MESSAGE = "존재하지 않는 플레이어 이름입니다.";

    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;


    public LadderGame(Ladder ladder, Players players, Rewards rewards) {
        this.ladder = ladder;
        this.players = players;
        this.rewards = rewards;
    }


    public String getPlayerResult(String name) {
        if (players.isExistPlayer(name)) {
            return findPlayerReward(players.getPlayerNameOrderNumber(name), rewards);
        }
        return NOT_EXIST_PLAYER_NAME_MESSAGE;
    }

    private String findPlayerReward(int playerIndex, Rewards rewards) {
        int rewardIndex = ladder.getResultIndex(playerIndex);
        return rewards.getRewardByIndex(rewardIndex);
    }

    public Map<PlayerName, String> getAllPlayerResult() {
        Map<PlayerName, String> allPlayerResult = new HashMap<>();
        for (PlayerName playerName : players.getPlayersNames()) {
            int playerIndex = players.getPlayerNameOrderNumber(playerName.getName());
            allPlayerResult.put(playerName, findPlayerReward(playerIndex, rewards));
        }
        return allPlayerResult;
    }
}
