package domain.prize;

import java.util.Arrays;
import java.util.List;

public record Prizes(List<Prize> prizes) {
    public Prizes(final String[] names) {
        this(Arrays.stream(names).map(Prize::new).toList());
    }

    public Prize getByIndex(final int index) {
        return this.prizes.get(index);
    }
}
