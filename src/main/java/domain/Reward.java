package domain;

import domain.validator.Validator;

public class Reward {
    private final String reward;

    public Reward(String reward) {
        Validator.validateReward(reward);
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }
}
