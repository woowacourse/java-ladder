package ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    private static Scanner SCANNER = new Scanner(System.in);
    private static String DELIMITER;
    private static String INPUT_NAMES;
    private static String INPUT_REWARDS;
    private static String INPUT_HEIGHT;
    private static String INPUT_CANDIDATES;
    private static String WRONG_INPUT;

    static {
        DELIMITER = ",";
        INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
        INPUT_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
        INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
        INPUT_CANDIDATES = "결과를 보고 싶은 사람은?";
        WRONG_INPUT = "잘못된 입력입니다. 다시 입력해주세요.";
    }

    private static List<String> stringList(String message) {
        System.out.println(); // 빈 줄 추가.
        System.out.println(message);
        try {
            return filterInputs(SCANNER.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT);
            return stringList(message);
        }
    }

    public static List<String> names() {
        return stringList(INPUT_NAMES);
    }

    public static List<String> rewards() {
        return stringList(INPUT_REWARDS);
    }

    public static List<String> candidates() {
        return stringList(INPUT_CANDIDATES);
    }

    public static int height() {
        List<String> temp = stringList(INPUT_HEIGHT);
        try {
            final int height = Integer.parseInt(temp.get(0));
            return height > 0 ? height : 1;
        } catch (IllegalArgumentException e) {
            System.out.println(WRONG_INPUT);
            return height();
        }
    }

    private static List<String> filterInputs(String input) {
        List<String> tokens = Stream
                .of(input.split(DELIMITER))
                .map(x -> x.trim())
                .filter(x -> x.length() != 0)
                .collect(Collectors.toList());

        if (tokens.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return tokens;
    }
}