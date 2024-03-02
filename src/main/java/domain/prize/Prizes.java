package domain.prize;

import java.util.Arrays;
import java.util.List;

public record Prizes(List<Prize> items) {
    public Prizes(final String[] names) {
        this(Arrays.stream(names).map(Prize::new).toList());
    }

    public Prize getByIndex(final int index) {
        return this.items.get(index);
    }
}
