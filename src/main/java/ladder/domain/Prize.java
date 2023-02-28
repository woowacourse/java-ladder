package ladder.domain;

import java.util.List;

public class Prize {

    private static final String COUNT_NOT_MATCH_MESSAGE = "[ERROR] 플레이어의 수와 결과의 수를 동일하게 입력하세요.";
    private static final String WRONG_PRIZE_LENGTH_MESSAGE = "[ERROR] 각각의 실행 결과의 1자이상 5자이하로 입력하세요.";
    private static final int MAX_PRIZE_LENGTH = 5;
    private static final int MIN_PRIZE_LENGTH = 1;

    private final List<String> prizes;

    public Prize(final List<String> prizes, final int playerNamesCount) {
        validate(prizes, playerNamesCount);
        this.prizes = List.copyOf(prizes);
    }

    private void validate(final List<String> prizes, final int playerNamesCount) {
        validatePrizesCount(prizes, playerNamesCount);
        validateEachPrizeLength(prizes);
    }

    private void validatePrizesCount(final List<String> prizes, final int playerNamesCount) {
        if (prizes.size() != playerNamesCount) {
            throw new IllegalArgumentException(COUNT_NOT_MATCH_MESSAGE);
        }
    }

    private void validateEachPrizeLength(final List<String> prizes) {
        long countOverMaxLength = prizes.stream()
                .filter((prize) -> (prize.length() > MAX_PRIZE_LENGTH || prize.length() < MIN_PRIZE_LENGTH))
                .count();

        if (countOverMaxLength > 0) {
            throw new IllegalArgumentException(WRONG_PRIZE_LENGTH_MESSAGE);
        }
    }

    public String getPrizeByIndex(int playerPrizeIndex) {
        return prizes.get(playerPrizeIndex);
    }

    public List<String> getPrizes() {
        return List.copyOf(prizes);
    }
}
