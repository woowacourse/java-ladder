package domain;

import java.util.Arrays;
import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(int membersCount, List<Reward> rewards) {
        validate(membersCount, rewards);
        this.rewards = rewards;
    }

    public static Rewards from(int membersCount, String rawNames) {
        validateNull(rawNames);
        return new Rewards(membersCount, initialize(rawNames));
    }

    private void validate(int membersCount, List<Reward> rewards) {
        if (membersCount != rewards.size()) {
            throw new IllegalArgumentException("플레이어 수(" + membersCount + ")만큼 입력해주세요.");
        }
    }

    private static void validateNull(String rawNames) {
        if (rawNames == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    private static List<Reward> initialize(String rawNames) {
        return Arrays.stream(rawNames.split("\\s*,\\s*", -1))
            .map(String::trim)
            .map(Reward::from)
            .toList();
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
