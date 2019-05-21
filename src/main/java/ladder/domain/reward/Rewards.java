package ladder.domain.reward;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private List<Reward> rewards;

    public Rewards(String[] prizes) {
        checkPlayers(prizes);
        rewards = Arrays.stream(prizes)
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    private void checkPlayers(String[] prizes) {
        if (prizes == null || prizes.length == 0) {
            throw new IllegalArgumentException("rewards 가 1개 이상 존재해야 합니다.");
        }
    }

    public int size() {
        return rewards.size();
    }

    public Reward get(int index) {
        return rewards.get(index);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
