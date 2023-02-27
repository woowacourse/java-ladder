package domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(final List<String> prizes) {
        this.prizes = createPrizes(prizes);
    }

    private List<Prize> createPrizes(final List<String> prizes) {
        return prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public Prize query(final int position) {
        return prizes.get(position);
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }
}
