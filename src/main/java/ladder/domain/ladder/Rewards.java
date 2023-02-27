package ladder.domain.ladder;

import ladder.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = new ArrayList<>();
        IntStream.range(0, rewards.size())
                .forEach(position -> this.rewards.add(new Reward(rewards.get(position), position)));
    }

    public Reward findItem(Position position) {
        return rewards.stream()
                .filter(reward -> reward.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("플레이어의 실행 결과가 존재하지 않습니다."));
    }

    public List<String> getRewards() {
        return rewards.stream()
                .map(Reward::getName)
                .collect(Collectors.toList());
    }
}
