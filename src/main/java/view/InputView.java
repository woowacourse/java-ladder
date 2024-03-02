package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";
    private static final String ASK_PLAYER_NAMES = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_PRIZE_NAMES = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_HEIGHT_NOT_INTEGER = "최대 사다리 높이는 숫자로 입력 해야 합니다";
    private static final String ASK_TARGET = "\n결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static List<String> askPlayerNames() {
        System.out.println(ASK_PLAYER_NAMES);
        String input = scanner.nextLine();
        return parseNames(input);
    }

    public static List<String> askPrizeNames() {
        System.out.println(ASK_PRIZE_NAMES);
        String input = scanner.nextLine();
        return parseNames(input);
    }

    private static List<String> parseNames(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(String::strip)
                .toList();
    }

    public static int askLadderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        String input = scanner.nextLine();
        return parseLadderHeight(input);
    }

    private static int parseLadderHeight(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LADDER_HEIGHT_NOT_INTEGER);
        }
    }

    public static String askTargetName() {
        System.out.println(ASK_TARGET);
        return scanner.nextLine();
    }
}
