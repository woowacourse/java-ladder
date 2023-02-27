package domain.result;

import java.util.Objects;

public class Prize {

    private static final int MIN_PRIZE_LENGTH = 1;
    private static final int MAX_PRIZE_LENGTH = 5;
    private static final String WRONG_PRIZE_LENGTH_MESSAGE =
            "결과는 최소 " + MIN_PRIZE_LENGTH + " 글자 이상 " + MAX_PRIZE_LENGTH + " 이하 여야합니다.";

    private final String prize;

    public Prize(final String prize) {
        validatePrizeLength(prize);
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    private void validatePrizeLength(final String prize) {
        if (MIN_PRIZE_LENGTH > prize.length() || MAX_PRIZE_LENGTH < prize.length()) {
            throw new IllegalArgumentException(WRONG_PRIZE_LENGTH_MESSAGE);
        }
    }

    @Override
    public boolean equals(final Object o) {
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

    @Override
    public String toString() {
        return prize;
    }
}
