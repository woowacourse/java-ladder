package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String READ_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String READ_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INVALID_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INVALID_MAX_INTEGER_MESSAGE = "2,147,483,648 이상은 입력할 수 없습니다.";
    private static final String INVALID_NUMBER_DIGIT_MESSAGE = "10자리 수 이하만 입력 가능합니다.";
    private static final int MAXIMUM_NUMBER_DIGIT = 10;

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(READ_PLAYER_NAMES_MESSAGE);
        final String input = scanner.nextLine();

        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int readLadderHeight() {
        System.out.println(READ_LADDER_HEIGHT_MESSAGE);
        final String input = scanner.nextLine();

        return parseInt(input);
    }

    private int parseInt(final String input) throws IllegalArgumentException {
        long parseInt = getParseLong(input);
        validateInteger(parseInt);
        return (int) parseInt;
    }

    private static long getParseLong(final String input) {
        try {
            validateNumberDigit(input);
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private static void validateNumberDigit(final String input) {
        if (input.length() > MAXIMUM_NUMBER_DIGIT) {
            throw new IllegalArgumentException(INVALID_NUMBER_DIGIT_MESSAGE);
        }
    }

    private void validateInteger(final long parseLong) {
        if (parseLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_MAX_INTEGER_MESSAGE);
        }
    }
}
