package ladder.domain;

import static ladder.domain.PlayerName.NAME_MAXIMUM_LENGTH;

public class Reward {

    public static final String ERROR_LENGTH_OF_NAME = String.format(
            "보상은 %d자 이하여야 합니다.", NAME_MAXIMUM_LENGTH);
    private final String reward;

    public Reward(String reward) {
        validateNameLength(reward);
        this.reward = reward;
    }

    public String getName() {
        return reward;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH_OF_NAME);
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("보상을 입력하지 않았습니다.");
        }
    }


}
