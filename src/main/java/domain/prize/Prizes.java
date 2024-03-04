package domain.prize;

import java.util.Collections;
import java.util.List;

public class Prizes {
    public static final String SIZE_EXCEPTION_MESSAGE = "[ERROR] 결과의 수는 플레이어의 수와 같아야 합니다.";
    public static final String OUT_OF_BOUND_EXCEPTION_MESSAGE = "[ERROR] 범위를 벗어난 인덱스는 입력할 수 없습니다.";

    private final List<Prize> prizes;

    public Prizes(final List<Prize> prizes, final int prizeSize) {
        validateSize(prizes, prizeSize);
        this.prizes = prizes;
    }

    private void validateSize(final List<Prize> prizes, final int prizeSize) {
        if (prizes.size() != prizeSize) {
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }

    public Prize findPrizeByIndex(final int index) {
        if (index < 0 || index >= prizes.size()) {
            throw new IllegalArgumentException(OUT_OF_BOUND_EXCEPTION_MESSAGE);
        }
        return prizes.get(index);
    }

    public int findMaxPrizeLength() {
        return prizes.stream()
                .mapToInt(prize -> prize.getValue().length())
                .max()
                .orElse(0);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

}
