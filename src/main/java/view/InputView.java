package view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import utils.Parser;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String line = scanner.next();
        return Parser.parse(line, ",");
    }

    public static int readHeight() {
        System.out.println(READ_HEIGHT_MESSAGE);
        String line = scanner.next();
        validateInteger(line);
        return Integer.parseInt(line);
    }

    private static void validateInteger(String line) {
        if (!NUMBER.matcher(line).matches()) {
            throw new IllegalArgumentException("사다리의 높이는 자연수이어야 합니다.");
        }
    }
}
