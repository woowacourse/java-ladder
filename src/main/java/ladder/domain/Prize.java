package ladder.domain;

import java.util.Objects;

public class Prize {
    private final String prizeName;

    private static final int MAX_LENGTH = 5;

    public Prize(String prizeName) {
        checkValidPrize(prizeName);
        this.prizeName = prizeName;
    }

    private void checkValidPrize(String prizeName) {
        checkBlank(prizeName);
        checkPrizeLength(prizeName);
    }

    private void checkPrizeLength(String prizeName) {
        if (prizeName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBlank(String prizeName) {
        if (prizeName == null || prizeName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String getPrizeName() {
        return prizeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(prizeName, prize.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }
}
