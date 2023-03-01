package laddergame.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String ERROR_PREFIX = System.lineSeparator() + "[ERROR] ";
    private static final String ERROR_BLANK = "빈 문자열은 입력이 불가합니다.";
    private static final String ERROR_HEIGHT_IS_NOT_NUMBER = "사다리의 높이는 숫자로 입력되어야합니다.";
    private static final String READ_PERSON_NAMES_MSG = System.lineSeparator() + "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_EXECUTION_RESULTS_NAMES_MSG =
        System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_LADDER_HEIGHT_MSG = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final String READ_WANT_REWARD_PARTICIPANT =
        System.lineSeparator() + "결과를 보고 싶은 사람은? (전부 보려면 all을 입력하세요)";
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipants() {
        System.out.println(READ_PERSON_NAMES_MSG);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return List.of(input.split(DELIMITER));
    }

    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    public void printErrorMsg(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public List<String> readRewards() {
        System.out.println(READ_EXECUTION_RESULTS_NAMES_MSG);
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

    public String readParticipantWantToSee() {
        System.out.println(READ_WANT_REWARD_PARTICIPANT);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return input;
    }

    public Power readReGame() {
        try {
            System.out.println(Power.printPowerMsg());
            return Power.validate(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return readReGame();
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
