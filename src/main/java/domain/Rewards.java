package domain;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewards, int memberCount) {
        validateCount(rewards, memberCount);
        return new Rewards(rewards.stream()
                .map(Reward::new)
                .toList());
    }

    private static void validateCount(List<String> rewards, int memberCount) {
        if (rewards.size() != memberCount) {
            throw new IllegalArgumentException("결과의 수는 참여자의 수와 같아야 합니다.");
        }
    }

    public Reward findResultByPosition(int index) {
        return rewards.get(index);
    }

    public List<String> getValues() {
        return rewards.stream()
                .map(Reward::getValue)
                .toList();
    }
}
