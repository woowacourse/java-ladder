package domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Names names;
    private final Lines lines;
    private final Rewards rewards;
    private final Map<Name, Reward> result = new HashMap<>();

    public Result(Names names, Lines lines, Rewards rewards) {
        this.names = names;
        this.lines = lines;
        this.rewards = rewards;
        calculateResult();
    }

    private void calculateResult() {
        for (int i = 0; i < names.getPersonNumber(); i++) {
            int index = getRewardIndex(i);
            Name name = names.getNames().get(i);
            Reward reward = rewards.getRewards().get(index);
            result.put(name, reward);
        }
    }

    private int getRewardIndex(int index) {
        for (Line line : lines.getLines()) {
            index += getWeight(index, line);
        }
        return index;
    }

    private int getWeight(int index, Line line) {
        if (isAbleForward(index, line)) {
            return 1;
        }
        if (isAbleBackward(index, line)) {
            return -1;
        }
        return 0;
    }

    private boolean isAbleForward(int index, Line line) {
        return index < line.getLineSize() && line.getLine().get(index);
    }

    private boolean isAbleBackward(int index, Line line) {
        return index > 0 && line.getLine().get(index - 1);
    }

    public Reward getReward(Name name) {
        return result.get(name);
    }
}
