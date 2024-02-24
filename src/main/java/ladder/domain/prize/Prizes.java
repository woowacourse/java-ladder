package ladder.domain.prize;

import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames, int playersCount) {
        validateSize(prizeNames.size(), playersCount);

        List<Prize> prizes = prizeNames.stream()
                .map(Prize::new)
                .toList();

        return new Prizes(prizes);
    }

    private static void validateSize(int prizesSize, int playersCount) {
        if (prizesSize != playersCount) {
            throw new IllegalArgumentException("참가자 수와 상품 수가 일치하지 않습니다.");
        }
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
