package ladderGame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final Scanner scanner;
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[1-9][0-9]*$");
    private static final String INPUT_MESSAGE_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MESSAGE_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXCEPTION_MESSAGE_NOT_NATURAL_NUMBER = "최대 사다리 높이는 자연수여야 합니다.";

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public List<String> inputPlayerNames() {
        System.out.println(INPUT_MESSAGE_PLAYER_NAMES);
        return Arrays.stream(scanner.nextLine().split(",", -1)).toList();
    }

    public int inputMaxLadderHeight() {
        System.out.println(System.lineSeparator() + INPUT_MESSAGE_MAX_LADDER_HEIGHT);
        String height = scanner.nextLine();
        validateNotNaturalNumber(height);
        return Integer.parseInt(height);
    }

    private void validateNotNaturalNumber(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_NATURAL_NUMBER);
        }
    }
}
