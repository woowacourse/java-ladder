package ladder.domain.resource.prize;

import java.util.List;

public class Prizes {

    private static final int MIN_PRIZE_SIZE = 2;
    private static final int MAX_PRIZE_SIZE = 10;

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        validatePrizeSize(prizes);
        this.prizes = prizes;
    }

    private void validatePrizeSize(List<Prize> prizes) {
        if (prizes.size() < MIN_PRIZE_SIZE || prizes.size() > MAX_PRIZE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨품은 2~10개 까지만 등록 가능합니다.");
        }
    }
}
