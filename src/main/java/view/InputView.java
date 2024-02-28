package view;

import exception.Message;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_REQUEST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_REQUEST_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_SEPARATOR = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayersName() {
        System.out.println(PLAYERS_REQUEST_MESSAGE);
        String rawNames = scanner.nextLine();
        validateBlank(rawNames);
        validateSeparators(rawNames);
        List<String> names = List.of(rawNames.split(NAME_SEPARATOR, -1));
        System.out.println();
        return names;
    }

    private void validateBlank(String rawNames) {
        if (rawNames == null || rawNames.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.BLANK_INPUT_ERROR.getMessage());
        }
    }

    private void validateSeparators(String rawNames) {
        if (rawNames.startsWith(NAME_SEPARATOR)
                || rawNames.endsWith(NAME_SEPARATOR)
                || rawNames.contains(NAME_SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException(Message.INVALID_SEPARATOR_ERROR.getMessage());
        }
    }

    public int readHeight() {
        System.out.println(HEIGHT_REQUEST_MESSAGE);
        String rawHeight = scanner.nextLine();
        validateBlank(rawHeight);
        int height = convert(rawHeight);
        System.out.println();
        return height;
    }

    private int convert(String rawHeight) {
        try {
            return Integer.parseInt(rawHeight);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getMessage());
        }
    }
}
