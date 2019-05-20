package ladder.domain;

import java.util.Objects;

public class Prize {
    private static int MAX_LENGTH = 5;

    private String prize;

    public Prize(String prize) {
        checkValidPrize(prize);
        this.prize = prize;
    }

    private void checkValidPrize(String prize) {
        checkBlankOrNull(prize);
        checkWrongLength(prize);
    }

    private void checkBlankOrNull(String prize) {
        if (prize == null || prize.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkWrongLength(String prize) {
        if (prize.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getPrize() {
        return this.prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
