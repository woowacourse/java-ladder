package view;

import java.util.List;
import java.util.Scanner;
import utils.StringParser;

public class InputView {

    private static final String USER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_NAMES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_VIEWER_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readUserNames() {
        System.out.println(USER_NAMES_MESSAGE);
        String userNames = scanner.nextLine();
        return StringParser.splitByDelimiter(userNames);
    }

    public static List<String> readResultNames() {
        System.out.println(RESULT_NAMES_MESSAGE);
        String resultNames = scanner.nextLine();
        return StringParser.splitByDelimiter(resultNames);
    }

    public static String readResultViewer() {
        System.out.println(RESULT_VIEWER_MESSAGE);
        return scanner.nextLine();

    }

    public static int readLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        String ladderHeight = scanner.nextLine();
        return StringParser.parseToInteger(ladderHeight);
    }
}
