package validation;

public class InputValidator {
    public static final String PLAYER_NAME_NULL_BLANK_ERROR_MESSAGE = "[ERROR] 플레이어의 이름으로 공백 혹은 빈 칸을 입력할 수 없습니다";
    public static final String LADDER_HEIGHT_ERROR_MESSAGE = "[ERROR] 사다리의 높이는 숫자를 입력해야합니다";
    public static final String LADDER_HIGHT_NEGATIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 사다리는 양의 정수여야 합니다.";

    public static void validatePlayerNameInput(String playerName) {
        if (playerName.isBlank() || playerName.isEmpty()) {
            throw new IllegalArgumentException(PLAYER_NAME_NULL_BLANK_ERROR_MESSAGE);
        }
    }

    public static void validateLadderHeightInput(String ladderHeight) {
        validateLadderHeightIsNumber(ladderHeight);
        validateLadderHeightIsPositiveNumber(ladderHeight);
    }

    private static void validateLadderHeightIsNumber(String ladderHeight) {
        try {
            Integer.parseInt(ladderHeight);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    private static void validateLadderHeightIsPositiveNumber(String ladderHeight) {
        if (Integer.parseInt(ladderHeight) <= 0) {
            throw new IllegalArgumentException(LADDER_HIGHT_NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
