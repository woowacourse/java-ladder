package domain.prize;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    public static final String PRIZE_SIZE_ERROR_MESSAGE = "[ERROR] 유저 수에 맞게 입력해주세요.";

    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames, int size) {
        validatePrizesSize(prizeNames, size);
        this.prizes = new ArrayList<>();
        for (String prizeName : prizeNames) {
            this.prizes.add(new Prize(prizeName));
        }
    }

    public List<String> getPrizeNames() {
        List<String> prizeNames = new ArrayList<>();
        for (Prize prize : prizes) {
            prizeNames.add(prize.getPrizeName());
        }
        return prizeNames;
    }

    private void validatePrizesSize(List<String> prizes, int size) {
        if (prizes.size() != size) {
            throw new IllegalArgumentException(PRIZE_SIZE_ERROR_MESSAGE);
        }
    }
}
