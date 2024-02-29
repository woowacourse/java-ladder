package ladder.domain.prize;

import java.util.Collections;
import java.util.List;

public class GamePrizes {

    private static final int MAXIMUM_PRIZE_LENGTH = 5;
    private final List<String> prizes;

    public GamePrizes(List<String> gamePrizesInput, int availablePrizeCount) {
        validate(gamePrizesInput, availablePrizeCount);
        this.prizes = gamePrizesInput;
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

    public String findPrize(int prizePosition) {
        return prizes.get(prizePosition);
    }

    private void validate(List<String> gamePrizesInput, int availablePrizeCount) {
        validateNotHasBlank(gamePrizesInput);
        validateCountIsCorrespondent(gamePrizesInput.size(), availablePrizeCount);
        validateHasOverMaximumLength(gamePrizesInput);
    }

    private void validateHasOverMaximumLength(List<String> gamePrizesInput) {
        for (String gamePrize : gamePrizesInput) {
            if (gamePrize.length() > MAXIMUM_PRIZE_LENGTH) {
                throw new IllegalArgumentException("최대 글자 개수는 " + MAXIMUM_PRIZE_LENGTH + "개 입니다.");
            }
        }
    }

    private void validateNotHasBlank(List<String> gamePrizeInput) {
        if (hasBlank(gamePrizeInput)) {
            throw new IllegalArgumentException("상품 목록엔 빈칸이 포함될 수 없습니다.");
        }
    }

    private void validateCountIsCorrespondent(int prizeCount, int availablePrizeCount) {
        if (prizeCount != availablePrizeCount) {
            throw new IllegalArgumentException("참가자와 상품의 개수가 일치하지 않습니다.");
        }
    }

    private boolean hasBlank(List<String> gamePrizeInput) {
        return gamePrizeInput.stream()
                .anyMatch(String::isBlank);
    }
}
