package domain;

import constant.domain.PrizeExceptionMessage;

import java.util.Objects;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        validateNoPrize(prize);
        this.prize = prize;
    }

    private void validateNoPrize(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException(PrizeExceptionMessage.NO_PRIZE.getExceptionMessage());
        }
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
