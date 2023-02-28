package view;

import utils.Parser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final InputView inputView = new InputView();
    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String READ_PRIZES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "사다리의 높이는 숫자여야 합니다.";
    private static final String READ_RESULT_COMMAND_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String INPUT_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public List<String> readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String line = scanner.nextLine();
        return Parser.parse(line, INPUT_DELIMITER);
    }

    public int readHeight() {
        System.out.println(READ_HEIGHT_MESSAGE);
        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public List<String> readPrizes() {
        System.out.println(READ_PRIZES_MESSAGE);
        String line = scanner.nextLine();
        return Parser.parse(line, INPUT_DELIMITER);
    }

    public String readResultOfPlayer() {
        System.out.println(READ_RESULT_COMMAND_MESSAGE);
        String line = scanner.nextLine();
        System.out.println();
        return line;
    }
}
