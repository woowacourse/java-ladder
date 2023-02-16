package view;

import java.util.List;
import java.util.Scanner;

import utils.Parser;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NOT_INTEGER_MESSAGE = "사다리의 높이는 숫자여야 합니다.";
    private static final String NAME_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String line = scanner.next();
        return Parser.parse(line, NAME_DELIMITER);
    }

    public static int readHeight() {
        System.out.println(READ_HEIGHT_MESSAGE);
        String line = scanner.next();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }
}
