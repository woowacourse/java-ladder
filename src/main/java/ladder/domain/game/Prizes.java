package ladder.domain.game;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(final List<String> prizes, final int playerCount) {
        validatePrizes(prizes, playerCount);
        this.prizes = new ArrayList<>(prizes);
    }

    private void validatePrizes(final List<String> prizes, final int playerCount) {
        if (prizes.size() != playerCount) {
            throw new IllegalArgumentException("상품의 수와 게임에 참여하는 참여자의 수가 다를 수 없습니다.");
        }
    }
}
