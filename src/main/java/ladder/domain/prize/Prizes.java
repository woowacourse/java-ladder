package ladder.domain.prize;

import ladder.domain.prize.exception.PrizeNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(int playerNumber, List<String> names) {
        validatePrizeCount(playerNumber, names.size());

        this.prizes = names.stream()
                .map(Prize::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validatePrizeCount(int playerNumber, int prizeNumber) {
        if (playerNumber != prizeNumber) {
            throw new PrizeNumberException();
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
