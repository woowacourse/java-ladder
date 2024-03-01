package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {

    static final String ERROR_IS_INVALID_LENGTH = "실행 결과 개수는 참여자 수와 일치해야 합니다.";

    private final List<Prize> prizes;

    public Prizes(List<String> prizeInputs, int playerCount) {
        validatePrizesLength(prizeInputs, playerCount);
        this.prizes = new ArrayList<>();
        preparePrizes(prizeInputs);
    }

    private void validatePrizesLength(List<String> prizes, int columnLength) {
        if (prizes.size() != columnLength) {
            throw new IllegalArgumentException(ERROR_IS_INVALID_LENGTH);
        }
    }

    private void preparePrizes(List<String> prizeInputs) {
        for (int i = 0; i < prizeInputs.size(); i++) {
            Prize prize = new Prize(prizeInputs.get(i));
            prizes.add(prize);
        }
    }

    public Prize findPrizeByPosition(int position) {
        return prizes.get(position);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
