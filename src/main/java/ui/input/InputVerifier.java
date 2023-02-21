package ui.input;

import java.util.Arrays;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
class InputVerifier {

    final static int MAX_NAME_LENGTH = 5;

    protected static List<String> validateName(String input) {
        validatePeopleNumberOverThanOne(input);
        List<String> names = splitInput(input);
        return names;
    }

    private static List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    private static void validatePeopleNumberOverThanOne(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("최소 2명의 참가자를 입력해야 합니다.");
        }
    }

    public static int validateLadderHeight(String numberStr) {
        int number = Integer.parseInt(numberStr);
        if (number <= 0) {
            throw new IllegalArgumentException("사다리 높이는 자연수로 입력해 주세요");
        }
        return number;
    }
}
