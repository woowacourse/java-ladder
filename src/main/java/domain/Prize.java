package domain;

import exception.InvalidPrizeNameException;

public class Prize {

    private static final String PRIZE_NAME_NULL_ERROR_MESSAGE = "상품의 이름은 null이면 안됩니다.";
    private static final String PRIZE_NAME_BLANK_ERROR_MESSAGE = "상품의 이름은 빈칸이면 안됩니다.";


    private final String prize;

    public Prize(String prize) {
        validatePrizeNameIsNull(prize);
        validatePrizeNameIsBlank(prize);
        this.prize = prize;
    }

    private void validatePrizeNameIsNull(String prize) {
        if (prize == null) {
            throw new InvalidPrizeNameException(PRIZE_NAME_NULL_ERROR_MESSAGE);
        }
    }

    private void validatePrizeNameIsBlank(String prize) {
        if (prize.isBlank()) {
            throw new InvalidPrizeNameException(PRIZE_NAME_BLANK_ERROR_MESSAGE);
        }
    }
}
