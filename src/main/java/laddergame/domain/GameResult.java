package laddergame.domain;

import static laddergame.utils.ErrorMessage.INVALID_GAME_RESULT_LENGTH;

public class GameResult {
    private final static int MIN_RESULT_LENGTH = 1;
    private final static int MAX_RESULT_LENGTH = 5;
    private final static String BLANK = " ";

    private final String result;

    public GameResult(String result) {
        validateResult(result);
        this.result = result;
    }

    private void validateResult(String result) {
        validateResultLength(result);
        validateResultFormat(result);
    }

    private void validateResultLength(String result) {
        if (isLongerThanMaxLength(result) || isShorterThanMinLength(result)) {
            throw new IllegalArgumentException(
                    String.format(INVALID_GAME_RESULT_LENGTH.getMessage(), MIN_RESULT_LENGTH, MAX_RESULT_LENGTH));
        }
    }

    private boolean isShorterThanMinLength(String result) {
        return result.length() < MIN_RESULT_LENGTH;
    }

    private boolean isLongerThanMaxLength(String result) {
        return result.length() > MAX_RESULT_LENGTH;
    }

    private void validateResultFormat(String result) {
        if (result.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    public String getResult() {
        return result;
    }
}
