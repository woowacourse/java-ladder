package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private static final String NOT_EXIST_PLAYER_NAME_MESSAGE = "존재하지 않는 플레이어 이름입니다.";

    private final Ladder ladder;
    private final PlayerNames playerNames;
    private final Rewards rewards;

    public LadderGame(Ladder ladder, PlayerNames playerNames, Rewards rewards) {
        this.ladder = ladder;
        this.playerNames = playerNames;
        this.rewards = rewards;
    }

    public String getPlayerResult(String name) {
        if (playerNames.isExistPlayer(name)) {
            return findPlayerReward(playerNames.getPlayerNameOrderNumber(name), rewards);
        }
        return NOT_EXIST_PLAYER_NAME_MESSAGE;
    }

    private String findPlayerReward(int playerIndex, Rewards rewards) {
        int rewardIndex = ladder.getResultIndex(playerIndex);
        return rewards.getRewardByIndex(rewardIndex);
    }

    public Map<PlayerName, String> getAllPlayerResult() {
        Map<PlayerName, String> allPlayerResult = new HashMap<>();
        for (PlayerName playerName : playerNames.getPlayerNames()) {
            int playerIndex = playerNames.getPlayerNameOrderNumber(playerName.getName());
            allPlayerResult.put(playerName, findPlayerReward(playerIndex, rewards));
        }
        return allPlayerResult;
    }
}
