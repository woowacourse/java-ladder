package ladder.domain.prize;

import java.util.List;

public class Prizes {

    private static final int MIN_PRIZE_SIZE = 2;
    private static final int MAX_PRIZE_SIZE = 10;

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public boolean isSameSize(int size) {
        return true;
    }
}
