package domain;

import java.util.Objects;

public class GameResult {

    public static final int MIN_RESULT_NAME_SIZE = 1;
    public static final int MAX_RESULT_NAME_SIZE = 5;

    private final String result;
    private final Player player;

    public GameResult(final Player player, final String result) {
        validate(result);
        this.player = player;
        this.result = result;
    }

    private void validate(final String result) {
        validateNullAndEmpty(result);
        validateResultNameSize(result);
    }

    private void validateNullAndEmpty(final String resultInput) {
        if (Objects.isNull(resultInput) || resultInput.isBlank()) {
            throw new IllegalArgumentException("한 개 이상의 실행 결과를 입력해야 합니다.");
        }
    }

    private void validateResultNameSize(final String result) {
        if (result.length() < MIN_RESULT_NAME_SIZE || result.length() > MAX_RESULT_NAME_SIZE) {
            throw new IllegalArgumentException("게임 실행 결과는 한 글자 이상 다섯글자 이하로 입력 가능합니다.");
        }
    }

    public String getGameResultName() {
        return result;
    }

    public Player getPlayer() {
        return player;
    }

}
