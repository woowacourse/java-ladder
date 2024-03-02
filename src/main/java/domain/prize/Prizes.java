package domain.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.player.Players;
import java.util.List;

public class Prizes {
    private static final String PRIZE_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참가자 수 : %d, 상품 수: %d - 참가자 수와 상품 수는 일치해야 합니다.";
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

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getName)
                .toList();
    }

    public Prize get(int index) { // todo 메서드, validation
        return prizes.get(index);
    }
}
