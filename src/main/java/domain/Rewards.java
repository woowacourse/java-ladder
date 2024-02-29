package domain;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(int membersCount, List<Reward> rewards) {
        validate(membersCount, rewards);
        this.rewards = rewards;
    }

    public static Rewards from(int membersCount, List<String> names) {
        return new Rewards(membersCount, initialize(names));
    }

    public String findRewardNameByIndex(int index) {
        if (index < 0 || index >= rewards.size()) {
            throw new IllegalArgumentException("올바르지 않은 상품 인덱스입니다.");
        }
        return rewards.get(index).getName();
    }

    private void validate(int membersCount, List<Reward> rewards) {
        if (membersCount != rewards.size()) {
            throw new IllegalArgumentException("플레이어 수(" + membersCount + ")만큼 입력해주세요.");
        }
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
}
