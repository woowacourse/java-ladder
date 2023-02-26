package domain.info;

public class Info {
    private final Names names;
    private final Rewards rewards;

    public Info(final Names names, final Rewards rewards) {
        validateSize(names.getNamesSize(), rewards.getRewardsSize());
        this.names = names;
        this.rewards = rewards;
    }

    private static void validateSize(final int namesLength, final int rewardsLength) {
        if (namesLength != rewardsLength) {
            throw new IllegalArgumentException("[ERROR] 이름의 수와 보상의 수는 같아야 합니다.");
        }
    }

    public Names getNames() {
        return names;
    }

    public Name getName(final int index) {
        return names.getName(index);
    }

    public int getNamesSize() {
        return names.getNamesSize();
    }

    public Rewards getRewards() {
        return rewards;
    }

    public Reward getReward(final int index) {
        return rewards.getReward(index);
    }
}
