package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizes) {
        return new Prizes(convertToPrizes(prizes));
    }

    private static List<Prize> convertToPrizes(List<String> prizes) {
        return prizes.stream().
                map(Prize::new)
                .collect(Collectors.toList());
    }

    public Prize findByIndex(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
