package ladder.domain.reward;

import static ladder.domain.player.PlayerName.NAME_MAXIMUM_LENGTH;

public class Reward {

    public static final String ERROR_OVER_LENGTH_REWARD = String.format(
            "보상은 %d자 이하여야 합니다.", NAME_MAXIMUM_LENGTH);
    public static final String ERROR_BLANK_REWARD = "보상을 입력하지 않았습니다.";
    private final String reward;

    public Reward(String reward) {
        validateRewardLength(reward);
        validateBlankReward(reward);
        this.reward = reward;
    }

    public String getName() {
        return reward;
    }

    private void validateRewardLength(String input) {
        if (input.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_LENGTH_REWARD);
        }
    }

    private void validateBlankReward(String input) {

        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_REWARD);
        }

    }

}
