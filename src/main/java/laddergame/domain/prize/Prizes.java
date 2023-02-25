package laddergame.domain.prize;

import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(final List<String> prizeNames) {
        this.prizes = createPrizes(prizeNames);
    }

    private List<Prize> createPrizes(final List<String> prizeNames) {
        return prizeNames.stream()
                .map(Prize::new)
                .collect(toList());
    }

    public Prize getPrize(final int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return unmodifiableList(prizes);
    }
}
