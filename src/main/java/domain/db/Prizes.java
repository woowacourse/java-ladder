package domain.db;

import java.util.Arrays;
import java.util.List;

public record Prizes(List<Prize> prizes) {
    public Prizes(String[] names) {
        this(Arrays.stream(names).map(Prize::new).toList());
    }
}
