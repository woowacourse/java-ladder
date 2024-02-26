package model.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import model.player.Players;

public class Prizes {
    private static final String INVALID_PRIZES_SIZE = "실행 결과는 참여자 등록 수와 같아야 합니다.";

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizeNames, Players players) {
        validatePrizeNamesSize(prizeNames, players);
        return prizeNames.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void validatePrizeNamesSize(List<String> prizeNames, Players players) {
        if (prizeNames.size() != players.getSize()) {
            throw new IllegalArgumentException(INVALID_PRIZES_SIZE);
        }
    }
}
