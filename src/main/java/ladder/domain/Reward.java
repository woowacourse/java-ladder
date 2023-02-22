package ladder.domain;

import java.util.List;

public class Reward {
    private final List<String> items;

    public Reward(final List<String> items) {
        this.items = items;
    }

    public String getRewardOf(final int i) {
        return items.get(i);
    }
}
