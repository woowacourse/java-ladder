package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes, Players players) {
        validatePlayerCount(prizes.size(), players.getPlayersCount());
        this.prizes = prizes;
    }

    private void validatePlayerCount(int resultsCount, int playerCount) {
        if (resultsCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 갯수와 참여할 사람이 같아야 합니다.");
        }
    }

    public Prize findPrizeByIndex(int index) {
        if (isProperIndex(index)) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위를 초과했습니다.");
        }
        return prizes.get(index);
    }

    private boolean isProperIndex(int index) {
        return index < 0 || index >= prizes.size();
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
