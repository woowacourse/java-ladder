package domain.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.player.Players;
import java.util.List;

public class Prizes {
    private static final String PRIZE_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참가자 수 : %d, 상품 수: %d - 참가자 수와 상품 수는 일치해야 합니다.";
    private static final String INDEX_EXCEPTION_MESSAGE = "[ERROR] rejected value: %d - 인덱스 범위를 벗어났습니다.";
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames, Players players) {
        validateSameAsPlayersCount(prizeNames, players);
        return prizeNames.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void validateSameAsPlayersCount(List<String> prizeNames, Players players) {
        int prizeCount = prizeNames.size();
        int playerCount = players.count();
        if (prizeCount != playerCount) {
            throw new IllegalArgumentException(
                    String.format(PRIZE_COUNT_EXCEPTION_MESSAGE, playerCount, prizeCount)
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
            throw new IllegalArgumentException(String.format(INDEX_EXCEPTION_MESSAGE, index));
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
