package model.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import model.player.Players;

public class Prizes {
    private static final String INVALID_SIZE_OF_PRIZE_NAMES = "실행 결과 수는 참여자 수와 같아야 합니다.";

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(Players players, List<String> prizeNames) {
        validateSizeOfPrizeNames(players, prizeNames);
        return prizeNames.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void validateSizeOfPrizeNames(Players players, List<String> prizeNames) {
        if (players.getSize() != prizeNames.size()) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_PRIZE_NAMES);
        }
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getName)
                .toList();
    }
}
