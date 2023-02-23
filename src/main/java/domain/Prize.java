package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prize {

    private static final String INVALID_PRIZE_LENGTH_ERROR_MESSAGE = "사다리 게임의 실행 결과는 1글자에서 5글자 사이로 입력해야합니다.";
    private static final String INVALID_PRIZE_COUNT_ERROR_MESSAGE = "사다리 게임의 실행 결과는 사람 수와 동일하게 입력해야합니다.";
    private static final int PRIZE_LENGTH_LOWER_BOUND = 1;
    private static final int PRIZE_LENGTH_UPPER_BOUND = 5;


    private final List<String> prizes;

    public Prize(List<String> prizes, int personCount) {
        List<String> timedPrizes = trimPrizes(prizes);
        validate(timedPrizes, personCount);
        this.prizes = timedPrizes;
    }

    private void validate(List<String> prizes, int personCount) {
        validatePrizesCount(prizes, personCount);
        validatePrizesLength(prizes);
    }

    private void validatePrizesCount(List<String> prizes, int personCount) {
        if (!isSameCount(prizes, personCount)) {
            throw new IllegalArgumentException(INVALID_PRIZE_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isSameCount(List<String> prizes, int personCount) {
        return prizes.size() == personCount;
    }

    private void validatePrizesLength(List<String> prizes) {
        if (hasInvalidPrizeLength(prizes)) {
            throw new IllegalArgumentException(INVALID_PRIZE_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean hasInvalidPrizeLength(List<String> prizes) {
        return prizes.stream()
                .filter(prize -> isInvalidNameLength(prize))
                .count() != 0;
    }

    private boolean isInvalidNameLength(String prize) {
        int length = prize.length();
        return length < PRIZE_LENGTH_LOWER_BOUND || length > PRIZE_LENGTH_UPPER_BOUND;
    }

    private List<String> trimPrizes(List<String> prizes) {
        return prizes.stream()
                .map(prize -> prize.trim())
                .collect(Collectors.toList());
    }

    public String getOnePrizeByIndex(int index) {
        return prizes.get(index);
    }

    public List<String> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
