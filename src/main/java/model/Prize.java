package model;

import java.util.Objects;

public class Prize {
    private static final int MIN_RANGE_LIMIT = 1;
    private static final int MAX_RANGE_LIMIT = 5;

    private final String prizeName;

    public Prize(String prizeText) {
        validateBlankNames(prizeText);
        validateNameLength(prizeText);
        prizeName = prizeText;
    }

    private void validateBlankNames(String prizeText) {
        if (prizeText.isBlank()) {
            throw new IllegalArgumentException("상품의 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String prizeText) {
        if (isOutOfRange(prizeText.length())) {
            String outOfRangeMessage = "상품의 이름은 %d~%d 까지만 허용합니다.".formatted(MIN_RANGE_LIMIT, MAX_RANGE_LIMIT);
            throw new IllegalArgumentException(outOfRangeMessage);
        }
    }

    private boolean isOutOfRange(int textLength) {
        return textLength < MIN_RANGE_LIMIT || textLength > MAX_RANGE_LIMIT;
    }

    public String getPrizeName() {
        return prizeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize = (Prize) o;
        return Objects.equals(this.prizeName, prize.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }
}
