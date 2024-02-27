package ladder.domain.prize;

import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizeNames) {
        List<Prize> prizes = prizeNames.stream()
                .map(Prize::new)
                .toList();

        return new Prizes(prizes);
    }

    public int size() {
        return prizes.size();
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
