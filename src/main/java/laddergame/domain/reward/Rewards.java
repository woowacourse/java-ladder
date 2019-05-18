package laddergame.domain.reward;

import laddergame.BuilderObject;
import laddergame.domain.Constant;

import java.util.List;
import java.util.Objects;

public class Rewards implements BuilderObject {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    @Override
    public String getNameOfIndex(int index) {
        return rewards.get(index - 1).getName();
    }

    @Override
    public boolean isSizeEqual(BuilderObject other) {
        return (this.rewards.size() == other.getSize());
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rewards)) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Reward reward : rewards) {
            stringBuilder.append(String.format("%-" + reward.BOUND_OF_NAME_LENGTH + "s", reward));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
