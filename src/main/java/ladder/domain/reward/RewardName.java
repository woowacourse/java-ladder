package ladder.domain.reward;

import java.util.Objects;

public class RewardName {

    public static final int NAME_MAXIMUM_LENGTH = 5;
    public static final String ERROR_OVER_LENGTH_REWARD = String.format(
            "보상은 %d자 이하여야 합니다.", NAME_MAXIMUM_LENGTH);
    public static final String ERROR_BLANK_REWARD = "보상을 입력하지 않았습니다.";

    private final String name;

    public RewardName(String name) {
        validateRewardName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateRewardName(String name) {
        validateRewardLength(name);
        validateBlankReward(name);
    }

    private void validateRewardLength(String input) {
        if (input.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_LENGTH_REWARD);
        }
    }

    private void validateBlankReward(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_REWARD);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardName name1 = (RewardName) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
