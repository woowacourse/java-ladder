package domain.result;

import java.util.List;

public class Prizes {

    private static final String PRIZE_SIZE_ERROR_MESSAGE = "최소 2개 이상의 결과가 존재해야 합니다.";
    private static final String PRIZE_BLANK_ERROR_MESSAGE = "결과명에는 빈 문자열과 공백이 허용되지 않습니다.";
    private static final int PRIZE_MIN_SIZE = 2;

    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        validate(prizes);
        this.prizes = prizes;
    }

    private void validate(List<String> prizes) {
        if (prizes.size() < PRIZE_MIN_SIZE) {
            throw new IllegalArgumentException(PRIZE_SIZE_ERROR_MESSAGE);
        }

        if (hasBlankPrize(prizes)) {
            throw new IllegalArgumentException(PRIZE_BLANK_ERROR_MESSAGE);
        }
    }

    private boolean hasBlankPrize(List<String> prizes) {
        return prizes.stream()
                .anyMatch(String::isBlank);
    }

    public String findByIndex(int index) {
        if (index < 0 || index >= prizes.size()) {
            throw new IllegalArgumentException("일치하는 상품이 존재하지 않습니다.");
        }
        return prizes.get(index);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
