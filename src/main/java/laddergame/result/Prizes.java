package laddergame.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = new ArrayList<>(prizes);
    }

    public static Prizes from(List<String> prizeNames, int prizesCount) {
        validatePrizesCount(prizeNames.size(), prizesCount);

        List<Prize> prizes = new ArrayList<>();
        for (String prizeName : prizeNames) {
            Prize prize = new Prize(prizeName);
            prizes.add(prize);
        }
        return new Prizes(prizes);
    }

    private static void validatePrizesCount(int actualCount, int expectedCount) {
        if (actualCount != expectedCount) {
            throw new IllegalArgumentException("결과의 개수가 플레이어의 수와 일치하지 않습니다.");
        }
    }

    public String getPrizeName(int position) {
        return prizes.get(position)
                     .getPrizeName();
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                     .map(Prize::getPrizeName)
                     .collect(Collectors.toUnmodifiableList());
    }
}
