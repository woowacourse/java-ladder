package laddergame.domain.result;

import laddergame.domain.BuilderObject;
import laddergame.domain.Constant;

import java.util.List;
import java.util.Objects;

public class Rewards implements BuilderObject {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    @Override
    public int getIndexOfName(String name) {
        return 0;
    }

    @Override
    public String getNameOfIndex(int index) {
        return null;
    }

    @Override
    public boolean isCountsEqual() {
        return false;
    }

    @Override
    public int getCount() {
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
            stringBuilder.append(String.format("%-" + Constant.BOUND_OF_NAME_LENGTH + "s", reward));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
