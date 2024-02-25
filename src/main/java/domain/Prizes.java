package domain;

import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizeNames, int playerCount) {
        validateSize(prizeNames, playerCount);
        this.prizes = fromPrizeStrings(prizeNames);
    }

    private List<Prize> fromPrizeStrings(List<String> names) {
        return names.stream()
                    .map(Prize::new)
                    .toList();
    }

    private void validateSize(List<String> names, int playerCount) {
        if (names.size() != playerCount) {
            throw new IllegalArgumentException("상품의 개수가 플레이어 수와 일치하지 않습니다.");
        }
    }

    public List<Prize> getValue() {
        return Collections.unmodifiableList(prizes);
    }
}
