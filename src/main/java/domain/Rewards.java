package domain;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards from(List<String> names) {
        return new Rewards(initialize(names));
    }

    public String findRewardNameByIndex(int index) {
        if (index < 0 || index >= rewards.size()) {
            throw new IllegalArgumentException("올바르지 않은 상품 인덱스입니다.");
        }
        return rewards.get(index).getName();
    }

    private static List<Reward> initialize(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
        return names.stream()
            .map(Reward::from)
            .toList();
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public int getCount() {
        return rewards.size();
    }
}
