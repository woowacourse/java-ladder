package domain.prize;

import java.util.Collections;
import java.util.List;

public class PrizeNames {
    private final List<PrizeName> prizeNames;

    public PrizeNames(List<String> prizeNames, int playerCount) {
        validateSize(prizeNames, playerCount);
        this.prizeNames = fromPrizeStrings(prizeNames);
    }

    private List<PrizeName> fromPrizeStrings(List<String> names) {
        return names.stream()
                    .map(PrizeName::new)
                    .toList();
    }

    private void validateSize(List<String> names, int playerCount) {
        if (names.size() != playerCount) {
            throw new IllegalArgumentException("상품의 개수가 플레이어 수와 일치하지 않습니다.");
        }
    }

    public List<PrizeName> getValue() {
        return Collections.unmodifiableList(prizeNames);
    }
}
