package model.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import model.player.Players;

public class Prizes { // TODO: prize로 분리하기
    private static final String INVALID_SIZE_OF_LADDER_RESULT_CONTENTS = "실행 결과 수는 참여자 수와 같아야 합니다.";

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(Players players, List<String> prizeContents) {
        validateSizeOfPrizeContents(players, prizeContents);
        return prizeContents.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void validateSizeOfPrizeContents(Players players, List<String> prizeContents) {
        if (players.getSize() != prizeContents.size()) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_LADDER_RESULT_CONTENTS);
        }
    }

    public Prize get(int index) {
        return prizes.get(index);
    }
}
