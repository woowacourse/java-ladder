package domain.prize;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    public static final String PRIZE_SIZE_ERROR_MESSAGE = "[ERROR] 유저 수에 맞게 입력해주세요.";

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes, int size) {
        validatePrizesSize(prizes, size);
        this.prizes = prizes;
    }

    public List<String> getPrizeNames() {
        List<String> prizeNames = new ArrayList<>();
        for (Prize prize : prizes) {
            prizeNames.add(prize.getPrizeName());
        }
        return prizeNames;
    }

    private void validatePrizesSize(List<Prize> prizes, int size) {
        if (prizes.size() != size) {
            throw new IllegalArgumentException(PRIZE_SIZE_ERROR_MESSAGE);
        }
    }
}
