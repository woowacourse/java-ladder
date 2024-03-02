package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.Delimiter;
import util.StringUtil;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BLANK_EXCEPTION_MESSAGE = "[ERROR] 빈 값은 입력할 수 없습니다.";
    private static final String CONTAIN_SPACE_EXCEPTION_MESSAGE = "[ERROR] 공백은 포함될 수 없습니다.";

    private InputView() {
    }

    public static List<String> inputPlayerNames() {
        System.out.printf(
                "참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n", Delimiter.COMMA.getKorName(), Delimiter.COMMA.getValue()
        );
        String playerNames = SCANNER.nextLine();
        System.out.println();
        validate(playerNames);
        return Arrays.asList(StringUtil.splitWithDelimiter(playerNames));
    }

    public static List<String> inputPrizeNames() {
        System.out.printf(
                "실행 결과를 입력하세요. (결과는 %s(%s)로 구분하세요)%n", Delimiter.COMMA.getKorName(), Delimiter.COMMA.getValue()
        );
        String prizesNames = SCANNER.nextLine();
        System.out.println();
        validate(prizesNames);
        return Arrays.asList(StringUtil.splitWithDelimiter(prizesNames));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String rawHeight = SCANNER.nextLine();
        System.out.println();
        validate(rawHeight);
        return StringUtil.parseInt(rawHeight);
    }

    public static String inputPlayerNameToFindResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String playerName = SCANNER.nextLine();
        System.out.println();
        validate(playerName);
        return playerName;
    }

    private static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException(CONTAIN_SPACE_EXCEPTION_MESSAGE);
        }
    }
}
