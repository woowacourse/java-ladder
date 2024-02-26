package view;

import exception.Message;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PLAYERS_REQUEST_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_REQUEST_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_REQUEST_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    // todO: 이름 수정필요 (너무 그지 같음)
    private static final String PLAYER_CHECK_RESULT_REQUEST_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String SEPARATOR = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayersName() {
        System.out.println(PLAYERS_REQUEST_MESSAGE);
        String rawNames = scanner.nextLine();
        validateBlank(rawNames);
        validateSeparators(rawNames);
        List<String> names = List.of(rawNames.split(SEPARATOR, -1));
        System.out.println();
        return names;
    }

    private void validateBlank(String rawNames) {
        if (rawNames == null || rawNames.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.BLANK_INPUT_ERROR.getMessage());
        }
    }

    private void validateSeparators(String rawNames) {
        if (rawNames.startsWith(SEPARATOR)
                || rawNames.endsWith(SEPARATOR)
                || rawNames.contains(SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException(Message.INVALID_SEPARATOR_ERROR.getMessage());
        }
    }

    public int readHeight() {
        System.out.println(HEIGHT_REQUEST_MESSAGE);
        String rawHeight = scanner.nextLine();
        validateBlank(rawHeight);
        int height = parseInt(rawHeight);
        System.out.println();
        return height;
    }

    private int parseInt(String rawHeight) {
        try {
            return Integer.parseInt(rawHeight);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.INVALID_HEIGHT_ERROR.getMessage());
        }
    }

    public List<String> readResult() {
        System.out.println(RESULT_REQUEST_MESSAGE);
        String rawResult = scanner.nextLine();
        validateBlank(rawResult);
        validateSeparators(rawResult);
        List<String> result = List.of(rawResult.split(SEPARATOR, -1));
        System.out.println();
        return result;
    }

    //TODO: playersPrizeResults 랑 prize 둘 중 뭐가 맞을지 고민해보기
    public String readPlayerWantCheckResult() {
        System.out.println(PLAYER_CHECK_RESULT_REQUEST_MESSAGE);
        String rawName = scanner.nextLine();
        validateBlank(rawName);
        System.out.println();
        return rawName;
    }
}
