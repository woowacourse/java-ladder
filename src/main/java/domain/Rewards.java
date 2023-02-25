package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rewards {
    private static final String REWARDS_SIZE_ERROR_MESSAGE = "[ERROR] 플레이어 수에 맞는 실행 결과를 입력해주세요.";
    private static final String DELIMITER = ",";

    private final List<Reward> rewards;

    public Rewards(String inputRewards, int minSize) {
        inputRewards = validateRewards(inputRewards, minSize);
        this.rewards = createRewards(inputRewards);
    }

    private String validateRewards(String inputRewards, int minSize) {
        validateSize(inputRewards, minSize);
        return inputRewards;
    }

    private void validateSize(String inputRewards, int minSize) {
        if (List.of(inputRewards.split(DELIMITER)).size() != minSize) {
            throw new IllegalArgumentException(REWARDS_SIZE_ERROR_MESSAGE);
        }
    }

    private List<Reward> createRewards(String inputRewards) {
        return Stream.of(inputRewards.split(DELIMITER, -1)).map(Reward::new).collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public String getRewardByIndex(int playerIndex) {
        return rewards.get(playerIndex).getRewardName();
    }
}
