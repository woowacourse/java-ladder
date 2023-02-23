package domain;

import exception.InvalidPrizeName;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        validatePrizeNameIsNull(prize);
        validatePrizeNameIsBlank(prize);
        this.prize = prize;
    }

    private void validatePrizeNameIsNull(String prize) {
        if (prize == null) {
            throw new InvalidPrizeName("상품의 이름은 null이면 안됩니다.");
        }
    }

    private void validatePrizeNameIsBlank(String prize) {
        if (prize.isBlank()) {
            throw new InvalidPrizeName("상품의 이름은 빈칸이면 안됩니다.");
        }
    }
}
