package view;

import exception.Message;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PLAYERS_REQUEST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PRIZE_REQUEST_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_REQUEST_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_TO_CHECK_REQUEST_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String NAME_SEPARATOR = ",";
    private static final String PRIZE_SEPARATOR = ",";
    public static final String CHECKING_ALL_MESSAGE = "all";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayersName() {
        System.out.println(PLAYERS_REQUEST_MESSAGE);
        String rawNames = scanner.nextLine();
        validateBlank(rawNames);
        validateSeparators(rawNames, NAME_SEPARATOR);
        return List.of(rawNames.split(NAME_SEPARATOR, -1));
    }

    public List<String> readPrizes() {
        System.out.println();
        System.out.println(PRIZE_REQUEST_MESSAGE);
        String rawPrizes = scanner.nextLine();
        validateBlank(rawPrizes);
        validateSeparators(rawPrizes, PRIZE_SEPARATOR);
        return List.of(rawPrizes.split(PRIZE_SEPARATOR, -1));
    }

    private void validateSeparators(String rawNames, String separator) {
        if (rawNames.startsWith(NAME_SEPARATOR)
                || rawNames.endsWith(separator)
                || rawNames.contains(separator.repeat(2))) {
            throw new IllegalArgumentException(Message.INVALID_SEPARATOR_ERROR.getMessage());
        }
    }

    public int readHeight() {
        System.out.println();
        System.out.println(HEIGHT_REQUEST_MESSAGE);
        String rawHeight = scanner.nextLine();
        validateBlank(rawHeight);
        int height = convertHeight(rawHeight);
        System.out.println();
        return height;
    }

    private void validateBlank(String rawNames) {
        if (rawNames == null || rawNames.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.BLANK_INPUT_ERROR.getMessage());
        }
    }

    private int convertHeight(String rawHeight) {
        try {
            return Integer.parseInt(rawHeight);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getMessage());
        }
    }

    public String readPlayerToCheck() {
        System.out.println();
        System.out.println(PLAYER_TO_CHECK_REQUEST_MESSAGE);
        return scanner.nextLine();
    }
}
