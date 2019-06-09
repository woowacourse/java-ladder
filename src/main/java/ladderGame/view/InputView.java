package ladderGame.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String ASK_PLAYER_NAME = "결과를 보고 싶은 사람은?";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPERATOR = ",";
    private static final String ASK_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULT_NAMES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_ROWS = "최대 사다리 높이는 몇 개인가요?";

    public static List<String> readPlayerNames() {
        System.out.println(ASK_PLAYER_NAMES);
        String input = SCANNER.nextLine();
        input = StringUtils.deleteWhitespace(input);
        return Arrays.asList(input.split(SEPERATOR));
    }

    public static List<String> readResults() {
        System.out.println(ASK_RESULT_NAMES);
        String input = SCANNER.nextLine();
        StringUtils.deleteWhitespace(input);
        return Arrays.asList(input.split(SEPERATOR));
    }

    public static int readRowNumber() {
        System.out.println(ASK_ROWS);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String readPlayer() {
        System.out.println(ASK_PLAYER_NAME);
        String input = SCANNER.nextLine();
        StringUtils.deleteWhitespace(input);
        return input;
    }
}
