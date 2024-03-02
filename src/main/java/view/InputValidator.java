package view;

import domain.Command;

public class InputValidator {

    static final String ERROR_PLAYER_NAME_IS_NULL_OR_BLANK = "참여자 이름을 입력해 주세요.";
    static final String ERROR_IS_IMPOSSIBLE_NAME = "은(는) 불가능한 이름입니다.";

    public static void validateIsNotCommand(String input) {
        if (Command.isAllCommand(input)) {
            throw new IllegalArgumentException(Command.ALL.getCommand() + ERROR_IS_IMPOSSIBLE_NAME);
        }
    }

    public static void validatePlayerName(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_PLAYER_NAME_IS_NULL_OR_BLANK);
        }
    }
}
