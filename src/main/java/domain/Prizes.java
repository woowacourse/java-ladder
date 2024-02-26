package domain;

import exception.domain.PrizesExceptionMessage;
import java.util.List;

public class Prizes {

    public static final int MAX_OF_PRIZE_LENGTH = 5;
    List<String> prizes;

    public Prizes(List<String> prizes) {
        validateNoPrize(prizes);
        validatePrizeLength(prizes);
        this.prizes = prizes;
    }

    private void validatePrizeLength(List<String> prizes) {
        prizes.stream()
                .filter(prize -> prize.length() > MAX_OF_PRIZE_LENGTH)
                .findFirst()
                .ifPresent(prize -> {
                    throw new IllegalArgumentException(PrizesExceptionMessage.OUT_OF_RANGE_PRIZE_LENGTH.getExceptionMessage());
                });
    }

    private void validateNoPrize(List<String> prizes) {
        prizes.stream()
                .filter(prize -> prize == null || prize.isBlank())
                .findFirst()
                .ifPresent(prize -> {
                    throw new IllegalArgumentException(PrizesExceptionMessage.NO_PRIZE.getExceptionMessage());
                });
    }
}
