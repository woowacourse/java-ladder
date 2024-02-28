package view;

import java.util.List;

public class InputValidator {

    static final String ERROR_PLAYER_NAME_IS_NULL_OR_BLANK = "참여자 이름을 입력해 주세요.";
    static final String ERROR_PLAYER_NAME_IS_NOT_EXISTED = "참여자 목록에 없는 이름입니다";
    static final String ERROR_IS_IMPOSSIBLE_NAME = "은(는) 불가능한 이름입니다.";
    private static final String ALL_COMMAND = "all";

    public static void validatePlayerName(List<String> playerNames, String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_PLAYER_NAME_IS_NULL_OR_BLANK);
        }

        if (!playerNames.contains(input) && !input.equals(ALL_COMMAND)) {
            throw new IllegalArgumentException(ERROR_PLAYER_NAME_IS_NOT_EXISTED);
        }
    }

    public static void validateIsNotCommand(String input) {
        if (input.equals(ALL_COMMAND)) {
            throw new IllegalArgumentException(ALL_COMMAND + ERROR_IS_IMPOSSIBLE_NAME);
        }
    }
}
