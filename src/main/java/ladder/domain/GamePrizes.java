package ladder.domain;

import java.util.List;

public class GamePrizes {

    private final List<String> prizes;

    public GamePrizes(List<String> gamePrizeInput) {
        validate(gamePrizeInput);
        this.prizes = gamePrizeInput;
    }

    public String findPrize(int position) {
        return prizes.get(position);
    }

    private void validate(List<String> gamePrizeInput) {
        validateNotHasBlank(gamePrizeInput);
    }

    private void validateNotHasBlank(List<String> gamePrizeInput) {
        if (hasBlank(gamePrizeInput)) {
            throw new IllegalArgumentException("상품 목록엔 빈칸이 포함될 수 없습니다.");
        }
    }

    private boolean hasBlank(List<String> gamePrizeInput) {
        return gamePrizeInput.stream()
                .anyMatch(String::isBlank);
    }
}
