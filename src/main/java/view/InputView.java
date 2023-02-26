package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String READ_PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_REWARDS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String READ_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String NOT_INTEGER_MESSAGE = "사다리의 높이는 숫자여야 합니다.";
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readPlayers() {
        System.out.println(READ_PLAYERS_MESSAGE);
        String line = scanner.nextLine();
        return StringParser.splitByComma(line, DELIMITER);
    }

    public static List<String> readRewards() {
        System.out.println(NEW_LINE + READ_REWARDS_MESSAGE);
        String line = scanner.nextLine();
        return StringParser.splitByComma(line, DELIMITER);
    }

    public static int readHeight() {
        System.out.println(NEW_LINE + READ_HEIGHT_MESSAGE);
        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

    public static String readName() {
        System.out.println(NEW_LINE + READ_NAME_MESSAGE);
        return scanner.nextLine();
    }
}
