package ladder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ladder.model.ErrorMessage.EXCEPTION_PLAYER_COUNT;
import static ladder.model.ErrorMessage.EXCEPTION_REWARD_COUNT;

public class LadderGame {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 30;
    private final List<Player> players;
    private final List<Reward> rewards;
    private final Height height;
    private Ladder ladder;
    private Map<Player, Reward> result;

    public LadderGame(List<Player> players, List<Reward> rewards, Height height) {
        validatePlayerCount(players);
        this.players = players;
        validateRewardsCount(rewards);
        this.rewards = rewards;
        this.height = height;
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT || players.size() > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_COUNT.getMessage());
        }
    }

    private void validateRewardsCount(List<Reward> rewards) {
        if (rewards.size() != players.size()) {
            throw new IllegalArgumentException(EXCEPTION_REWARD_COUNT.getMessage());
        }
    }

    public void generateLadder(LineCreateDecider lineCreateDecider) {
        int personCount = players.size();
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(personCount, lineCreateDecider));
        }
        ladder = new Ladder(rows);
    }

    public void playLadderGame() {
        this.result = new HashMap<>();

        for (int i = 0; i < players.size(); i++) {
            int rewardIndex = ladder.getResult(i);
            result.put(players.get(i), rewards.get(rewardIndex));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Map<Player, Reward> getResult() {
        return result;
    }
}
