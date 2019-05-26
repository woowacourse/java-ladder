package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards implements Iterable<Reward> {
    private static final String ITEM_SPLITTER = ",";

    private final List<Reward> rewards;

    public Rewards(final String rawRewards) {
        validateNoConsecutiveCommas(rawRewards);
        validateSurroundedWithComma(rawRewards);
        this.rewards = Collections.unmodifiableList(
                Arrays.asList(rawRewards.split(ITEM_SPLITTER)).stream()
                        .map(Reward::new).collect(Collectors.toList()));
    }

    private static void validateNoConsecutiveCommas(final String names) {
        if (names.contains(ITEM_SPLITTER + ITEM_SPLITTER)) {
            throw new IllegalArgumentException(ITEM_SPLITTER + "가 두개 이상 연달아 있으면 안 됩니다.");
        }
    }

    private void validateSurroundedWithComma(String rawNames) {
        if(rawNames.startsWith(ITEM_SPLITTER) || rawNames.endsWith(ITEM_SPLITTER)){
            throw new IllegalArgumentException(ITEM_SPLITTER + "로 시작하거나 끝나면 안 됩니다.");
        }
    }

    Reward getReward(int index) {
        return rewards.get(index);
    }

    public int getRewardSize() {
        return rewards.size();
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
