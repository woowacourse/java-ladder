package ladder.domain;

import java.util.List;

public class LadderRewards {
    private static final int REWARD_MAX_LENGTH = 6;

    private final List<String> rewards;

    public LadderRewards(List<String> rewards) {
        this.rewards = rewards;
    }

    String getResult(int index) {
        return rewards.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String reward : rewards) {
            sb.append(makeWhiteSpace(reward));
            sb.append(reward);
        }
        return sb.toString();
    }

    private String makeWhiteSpace(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < REWARD_MAX_LENGTH - name.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
