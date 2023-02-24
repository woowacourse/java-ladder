package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {
    private final Map<Position, Prize> prizes;

    private Prizes(Map<Position, Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizeNames, int prizesCount) {
        validatePrizesCount(prizeNames.size(), prizesCount);

        Map<Position, Prize> prizes = new HashMap<>();
        for (int i = 0; i < prizeNames.size(); i++) {
            Position prizePosition = new Position(i);
            Name prizeName = new Name(prizeNames.get(i));
            Prize prize = new Prize(prizeName);

            prizes.put(prizePosition, prize);
        }
        return new Prizes(prizes);
    }

    private static void validatePrizesCount(int actualCount, int expectedCount) {
        if (actualCount != expectedCount) {
            throw new IllegalArgumentException("결과의 개수가 플레이어의 수와 일치하지 않습니다.");
        }
    }

    public String getPrizeName(Position position) {
        return prizes.get(position)
                     .getName();
    }

    public List<String> getPrizeNames() {
        return prizes.values()
                     .stream()
                     .map(Prize::getName)
                     .collect(Collectors.toUnmodifiableList());
    }
}
