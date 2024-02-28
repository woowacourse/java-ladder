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
        if (prizes.size() != size) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 수가 사용자의 수와 동일하지 않습니다.");
        }
        return true;
    }
}
