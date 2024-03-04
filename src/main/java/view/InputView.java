package view;

import exception.Message;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_REQUEST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_REQUEST_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_REQUEST_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String TARGET_PLAYER_REQUEST_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String SEPARATOR = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayersName() {
        return readSeparateLine(PLAYERS_REQUEST_MESSAGE);
    }

    private void validateBlank(final String rawNames) {
        if (rawNames == null || rawNames.isBlank()) {
            throw new IllegalArgumentException(Message.BLANK_INPUT_ERROR.getValue());
        }
    }

    private void validateSeparators(final String rawNames) {
        if (isInvalidSeparator(rawNames)) {
            throw new IllegalArgumentException(Message.INVALID_SEPARATOR_ERROR.getValue());
        }
    }

    private boolean isInvalidSeparator(final String rawNames) {
        if (rawNames.startsWith(SEPARATOR)) {
            return true;
        }
        if (rawNames.endsWith(SEPARATOR)) {
            return true;
        }
        return rawNames.contains(SEPARATOR.repeat(2));
    }

    public int readHeight() {
        System.out.println(HEIGHT_REQUEST_MESSAGE);
        String rawHeight = scanner.nextLine();
        validateBlank(rawHeight);
        int height = parseInt(rawHeight);
        System.out.println();
        return height;
    }

    private int parseInt(final String rawHeight) {
        try {
            return Integer.parseInt(rawHeight);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getValue());
        }
    }

    public List<String> readPrizes() {
        return readSeparateLine(RESULT_REQUEST_MESSAGE);
    }

    private List<String> readSeparateLine(final String requestMessage) {
        System.out.println(requestMessage);
        String rawPrizes = scanner.nextLine();
        validateBlank(rawPrizes);
        validateSeparators(rawPrizes);
        List<String> prizes = List.of(rawPrizes.split(SEPARATOR));
        System.out.println();
        return prizes;
    }

    public String readPlayerNameToCheckPrize() {
        System.out.println(TARGET_PLAYER_REQUEST_MESSAGE);
        String rawName = scanner.nextLine();
        validateBlank(rawName);
        System.out.println();
        return rawName;
    }
}
