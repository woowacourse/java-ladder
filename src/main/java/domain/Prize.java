package domain;

import java.util.Objects;

public class Prize {

    public static final String NO_PRIZE = "[ERROR] 결과가 없습니다.";

    private final String prize;
    private final Position position;

    public Prize(String prize, int position) {
        validateNoPrize(prize);
        this.prize = prize;
        this.position = new Position(position);
    }

    private void validateNoPrize(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException(NO_PRIZE);
        }
    }

    public String getPrize() {
        return prize;
    }
    public Position getPosition() {
        return position;
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
