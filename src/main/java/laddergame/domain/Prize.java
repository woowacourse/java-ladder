package laddergame.domain;

import laddergame.constant.ErrorMessage;

public class Prize {

    private final String prize;
    public Prize(String prize) {
        validatePrize(prize);
        this.prize = prize;
    }

    private void validatePrize(String prize) {
        if (prize.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public String getPrize() {
        return prize;
    }
}
