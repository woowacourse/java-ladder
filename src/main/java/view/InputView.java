package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";
    private static final String NEW_LINE = System.getProperty("line.separator");

    private static final Scanner reader = new Scanner(System.in);

    public static List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNames = reader.next();
        return Arrays.stream(splitNames(playerNames))
                .collect(Collectors.toList());
    }

    private static String[] splitNames(final String playerNames) {
        return playerNames.split(SPLIT_DELIMITER);
    }

    public static String readResults() {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return reader.next();
    }

    public static int readHeight() {
        System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
        String input = reader.next();
        int ladderHeight = validateIntegerInput(input);
        return ladderHeight;
    }

    private static int validateIntegerInput(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("사다리 높이의 입력 값은 숫자만 가능합니다.");
        }
    }

    public static String readNameToShowResult() {
        System.out.println(NEW_LINE + "결과를 보고 싶은 사람은?");
        return reader.next();
    }
}
