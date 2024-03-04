package domain.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames, int validCount) {
        validateSameAsPlayersCount(prizeNames, validCount);
        return prizeNames.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void validateSameAsPlayersCount(List<String> prizeNames, int validCount) {
        int prizeCount = prizeNames.size();
        if (prizeCount != validCount) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %s - 현재 상품 개수는 %d개 입니다. %d개와 일치해야 합니다.",
                            prizeNames, prizeCount, validCount)
            );
        }
    }

    public int findMaxPrizeNameLength() {
        return prizes.stream()
                .mapToInt(Prize::getNameLength)
                .max()
                .orElse(0);
    }

    public Prize findPrizeByIndex(int index) {
        if (isOutOfRange(index)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %d - index가 범위를 벗어났습니다.", index));
        }
        return prizes.get(index);
    }

    private boolean isOutOfRange(int index) {
        return index < 0 || index >= prizes.size();
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getName)
                .toList();
    }
}
