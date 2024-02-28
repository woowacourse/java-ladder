package domain;

import java.util.Objects;

public class Prize {

    public static final int MAX_OF_PRIZE_LENGTH = 5;

    private final String prize;

    public Prize(String prize) {
        validatePrizeLength(prize);
        validateNoPrize(prize);
        this.prize = prize;
    }

    private void validatePrizeLength(String prize) {
        if (prize.length() > MAX_OF_PRIZE_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 실행 결과의 길이는 " + MAX_OF_PRIZE_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }

    private void validateNoPrize(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과가 없습니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Prize other = (Prize) obj;
        return Objects.equals(prize, other.prize);
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
