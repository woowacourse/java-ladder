package domain.prize;

import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(final List<String> prizes) {
        return new Prizes(convertToPrizes(prizes));
    }

    private static List<Prize> convertToPrizes(final List<String> prizes) {
        return prizes.stream().
                map(Prize::new)
                .toList();
    }

    public Prize findByIndex(final int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
