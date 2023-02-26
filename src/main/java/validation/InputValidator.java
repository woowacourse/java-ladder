package validation;

import exception.InvalidLadderHeightException;
import exception.NullOrBlankInputException;

public class InputValidator {

    private static final String NULL_BLANK_ERROR_MESSAGE = "공백 혹은 빈 칸을 입력할 수 없습니다";
    private static final String LADDER_HEIGHT_ERROR_MESSAGE = "사다리의 높이는 숫자를 입력해야합니다";
    private static final String LADDER_HEIGHT_NEGATIVE_NUMBER_ERROR_MESSAGE = "사다리는 양의 정수여야 합니다.";

    public static void validateNullOrBlankInput(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new NullOrBlankInputException(NULL_BLANK_ERROR_MESSAGE);
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
            throw new InvalidLadderHeightException(LADDER_HEIGHT_ERROR_MESSAGE);
        }
    }

    private static void validateLadderHeightIsPositiveNumber(String ladderHeight) {
        if (Integer.parseInt(ladderHeight) <= 0) {
            throw new InvalidLadderHeightException(LADDER_HEIGHT_NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
