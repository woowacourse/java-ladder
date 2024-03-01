package domain.prize;

import domain.player.Player;
import java.util.List;

public class Prizes {
    public static final String OUT_OF_BOUND_EXCEPTION_MESSAGE = "[ERROR] 범위를 벗어난 인덱스는 입력할 수 없습니다.";

    private final List<Prize> prizes;

    // TODO: 플레이어 수 만큼 Prize가 입력 되어야 한다.
    public Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Prize findPrizeByIndex(final int index) {
        if (index < 0 || index >= prizes.size()) {
            throw new IllegalArgumentException(OUT_OF_BOUND_EXCEPTION_MESSAGE);
        }
        return prizes.get(index);
    }

    public Prize findResultByPlayer(final Player player) {
        return findPrizeByIndex(player.getPosition());
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
