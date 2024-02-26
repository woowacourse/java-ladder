package ladder.domain;

import java.util.List;

public class GamePrize {

    private final List<String> prizes;

    public GamePrize(List<String> gamePrizeInput) {
        validate(gamePrizeInput);
        this.prizes = gamePrizeInput;
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
