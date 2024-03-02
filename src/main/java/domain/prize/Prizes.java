package domain.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.player.Players;
import java.util.List;

public class Prizes {
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
                    String.format("[ERROR] rejected value: %s - 참가자 수(%d)와 상품 수(%d)는 일치해야 합니다.",
                            prizeNames, playerCount, prizeCount)
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
