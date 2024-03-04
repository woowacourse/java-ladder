package ladder.domain.prize;

import java.util.List;

public class Prizes {

    private static final int MIN_PRIZE_SIZE = 2;
    private static final int MAX_PRIZE_SIZE = 10;

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        validatePrizeSize(prizes);
        this.prizes = prizes;
    }

    public int getSize() {
        return prizes.size();
    }

    public Prize getPrizeByIndex(int index) {
        return prizes.get(index);
    }

    private void validatePrizeSize(List<Prize> prizesToAdd) {
        if (prizesToAdd.size() < MIN_PRIZE_SIZE || prizesToAdd.size() > MAX_PRIZE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨품은 2~10개 까지만 등록 가능합니다.");
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
