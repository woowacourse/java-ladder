package ladder.view.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern notNumberPattern = Pattern.compile("\\D");

    public static void validateContainName(List<String> namesList, String inputWantGameResults) {
        if (!namesList.contains(inputWantGameResults) && !inputWantGameResults.equals("all")) {
            throw new IllegalArgumentException("해당하는 이름이 존재하지 않습니다.");
        }
    }

    public static void validateNonNumber(String ladderHeight) {
        Matcher matcher = notNumberPattern.matcher(ladderHeight);
        if (matcher.find()) {
            throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }

    public static int validateLadderHeightRange(int ladderHeight) {
        if (ladderHeight < 1 || ladderHeight > 100) {
            throw new IllegalArgumentException("사다리 높이는 1이상 100 이하만 입력할 수 있습니다.");
        }
        return ladderHeight;
    }

}
