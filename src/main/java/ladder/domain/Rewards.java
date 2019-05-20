package ladder.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards implements Iterable<Reward> {
    private final List<Reward> rewards;

    public Rewards(final List<String> rewards) {
        this.rewards = Collections.unmodifiableList(rewards.stream().map(reward -> new Reward(reward)).collect(Collectors.toList()));
    }

    public Reward getReward(int index) {
        return rewards.get(index);
    }

    @Override
    public Iterator<Reward> iterator() {
        return new Iterator<Reward>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < rewards.size();
            }

            @Override
            public Reward next() {
                return rewards.get(count++);
            }
        };
    }
}