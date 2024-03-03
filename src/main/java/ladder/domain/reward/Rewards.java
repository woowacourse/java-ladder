package ladder.domain.reward;

import java.util.List;
import java.util.function.Consumer;

import ladder.domain.attribute.Width;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(final List<Reward> rewards, final Width width) {
        validateSameSize(rewards, width);
        this.rewards = rewards;
    }

    private void validateSameSize(final List<Reward> rewards, final Width width) {
        if (rewards.size() != width.value()) {
            throw new IllegalArgumentException(
                    "인원수와 결과의 개수가 일치하지 않습니다: 인원수 %d개, 결과 %d개".formatted(
                            width.value(),
                            rewards.size()));
        }
    }

    public void forEach(final Consumer<Reward> consumer) {
        rewards.forEach(consumer);
    }

    public Reward get(final int index) {
        if (index < 0 || index >= rewards.size()) {
            throw new IllegalStateException("잘못된 위치입니다: %d".formatted(index));
        }
        return rewards.get(index);
    }
}
