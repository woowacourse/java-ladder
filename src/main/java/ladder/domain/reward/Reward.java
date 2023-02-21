package ladder.domain.reward;

import ladder.domain.player.Name;

public class Reward {

    private final String reward;

    public Reward(String reward) {
        validateBlank(reward);
        validateLength(reward);
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    private void validateLength(String reward) {
        if(reward.length() >= Name.NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("보상은 최대 " + Name.NAME_MAXIMUM_LENGTH+ "글자 입니다.");
        }
    }

    private void validateBlank(String reward) {
        if(reward.isBlank()) {
            throw new IllegalArgumentException("보상은 빈 문자열을 입력할 수 없습니다.");
        }
    }

}
