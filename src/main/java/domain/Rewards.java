package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

    private static void validateNull(String rawNames) {
        if (rawNames == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    private static List<Reward> initialize(String rawNames) {
        List<String> parsedNames = parse(rawNames);
        return parsedNames.stream()
            .map(Reward::from)
            .toList();
    }

    private static List<String> parse(String rawNames) {
        return Arrays.stream(rawNames.split(",", -1))
            .map(String::trim)
            .toList();
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
