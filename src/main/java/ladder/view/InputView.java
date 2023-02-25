package ladder.view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int LIMIT = -1;
    private static final String READ_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_GIFT_NAMES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "사다리 높이는 숫자만 입력 가능합니다. 현재 입력은 {0} 입니다.";
    private static final String READ_RESULT_COMMAND_MESSAGE = "결과를 보고 싶은 사람은?";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(READ_PLAYER_NAMES_MESSAGE);
        final String input = scanner.nextLine();
        return parseNames(input);
    }

    private List<String> parseNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, LIMIT))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> readGiftNames() {
        System.out.println(READ_GIFT_NAMES_MESSAGE);
        final String input = scanner.nextLine();
        return parseNames(input);
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

    public String readResultCommand() {
        System.out.println(READ_RESULT_COMMAND_MESSAGE);
        return scanner.nextLine();
    }
}
