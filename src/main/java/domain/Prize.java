package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prize {

    private static final String INVALID_PRIZE_LENGTH_ERROR_MESSAGE = "사다리 게임의 실행 결과는 1글자에서 5글자 사이로 입력해야합니다.";
    private static final int PRIZE_LENGTH_LOWER_BOUND = 1;
    private static final int PRIZE_LENGTH_UPPER_BOUND = 5;

    private final String prize;

    public Prize(String prize) {
        String trimmedPrize = prize.trim();
        validate(trimmedPrize);
        this.prize = trimmedPrize;
    }

    private void validate(String prize) {
        validatePrizeLength(prize);
    }

    private void validatePrizeLength(String prize) {
        if (isInvalidNameLength(prize)) {
            throw new IllegalArgumentException(INVALID_PRIZE_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidNameLength(String prize) {
        int length = prize.length();
        return length < PRIZE_LENGTH_LOWER_BOUND || length > PRIZE_LENGTH_UPPER_BOUND;
    }
}
