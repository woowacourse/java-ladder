package domain.reward;

import domain.common.Name;

public record Result(Name name, Reward reward) {
    public String nameToString() {
        return name.getValue();
    }

    public String rewardToString() {
        return reward.getValue();
    }
}
