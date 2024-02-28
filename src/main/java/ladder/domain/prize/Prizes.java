package ladder.domain.prize;

import java.util.List;

public class Prizes {

    private static final int MIN_PRIZE_SIZE = 2;
    private static final int MAX_PRIZE_SIZE = 10;

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes, int size) {
        this.prizes = prizes;
        validateSameSize(size);
    }

    public void validateSameSize(int size) {
        if (this.prizes.size() != size) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 수가 사용자의 수와 동일하지 않습니다.");
        }
    }
}
