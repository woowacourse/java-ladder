package domain;

import exception.InvalidPrizesSizeException;
import java.util.List;

public class Prizes {
    private static final String PRIZES_SIZE_ERROR_MESSAGE = "상품의 수는 플레이어의 수와 같아야한다.";

    private List<Prize> prizes;

    public Prizes(int playerCount, List<Prize> prizes) {
        validatePrizesSize(playerCount, prizes);
        this.prizes = prizes;
    }

    public Prize getPrize(int index) {
        return prizes.get(index);
    }

    private void validatePrizesSize(int playerCount, List<Prize> prizes) {
        if (prizes.size() != playerCount) {
            throw new InvalidPrizesSizeException(PRIZES_SIZE_ERROR_MESSAGE);
        }
    }

}
