package model.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> names) {
        return names.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    public Prize getPrizeByIndex(final int index) {
        return prizes.get(index);
    }
}
