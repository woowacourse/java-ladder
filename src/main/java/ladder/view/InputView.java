package ladder.view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int LIMIT = -1;
    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "사다리 높이는 숫자만 입력 가능합니다. 현재 입력은 {0} 입니다.";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(READ_NAMES_MESSAGE);
        final String input = scanner.nextLine();
        return parsePlayerNames(input);
    }

    private List<String> parsePlayerNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, LIMIT))
                .collect(Collectors.toUnmodifiableList());
    }

    public int readHeight() {
        System.out.println(READ_HEIGHT_MESSAGE);
        final String input = scanner.nextLine();
        return parseHeight(input);
    }

    private int parseHeight(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format(NUMBER_FORMAT_ERROR_MESSAGE, input));
        }
    }
}
