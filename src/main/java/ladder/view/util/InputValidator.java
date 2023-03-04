package ladder.view.util;

import java.util.List;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateContainName(List<String> namesList, String inputWantGameResults) {
        if (!namesList.contains(inputWantGameResults) && !inputWantGameResults.equals("all")) {
            throw new IllegalArgumentException("해당하는 이름이 존재하지 않습니다.");
        }
    }

    public static int validateLadderHeightRange(int ladderHeight) {
        if (ladderHeight < 1 || ladderHeight > 100) {
            throw new IllegalArgumentException("사다리 높이는 1이상 100 이하만 입력할 수 있습니다.");
        }
        return ladderHeight;
    }
}
