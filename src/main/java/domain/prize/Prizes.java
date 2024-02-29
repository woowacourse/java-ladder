package domain.prize;

import domain.player.Player;
import java.util.List;

public class Prizes {
    public static final String OUT_OF_BOUND_EXCEPTION_MESSAGE = "[ERROR] 범위를 벗어난 인덱스는 입력할 수 없습니다.";

    private final List<Prize> prizes;

    public Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Prize findPrizeByIndex(final int index) {
        if (index < 0 || index >= prizes.size()) {
            throw new IllegalArgumentException(OUT_OF_BOUND_EXCEPTION_MESSAGE);
        }
        return prizes.get(index);
    }

    // TODO: 결과가 이상하게 나와요 ㅜ ㅅ ㅜ
    public Prize findResultByPlayer(final Player player) {
        return findPrizeByIndex(player.getPosition());
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
