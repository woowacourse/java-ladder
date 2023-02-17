package laddergame.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_BLANK = "참여자의 이름은 빈 문자열로 입력되어선 안됩니다.";
    private static final String ERROR_HEIGHT_IS_NOT_NUMBER = "사다리의 높이는 숫자로 입력되어야합니다.";
    private static final String READ_PERSON_NAMES_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    public void printErrorMsg(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public List<String> readPersonNames() {
        System.out.println(READ_PERSON_NAMES_MSG);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return List.of(input.split(DELIMITER));
    }

    public int readLadderHeight() {
        System.out.println(READ_LADDER_HEIGHT_MSG);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ERROR_PREFIX + ERROR_HEIGHT_IS_NOT_NUMBER);
            return readLadderHeight();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
