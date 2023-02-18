package ui.input;

import java.util.Arrays;
import java.util.List;

class InputVerifier {

    protected static List<String> validateName(String input) {
        validatePeopleNumberOverThanOne(input);
        List<String> names = splitInput(input);
        validateNameLength(names);
        return names;
    }

    private static void validateNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 최대 5글자 까지만 입력할 수 있습니다.");
            }
        }
    }

    private static List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    private static void validatePeopleNumberOverThanOne(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("최소 2명의 참가자를 입력해야 합니다.");
        }
    }

    protected static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리의 단계는 자연수여야 합니다.");
        }
    }
}
