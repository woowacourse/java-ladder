package view;

import java.util.List;
import java.util.Scanner;

import utils.Parser;

public class InputView {

    private static final InputView inputView = new InputView();

    private final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final String READ_PRIZES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final String NOT_INTEGER_ERROR_MESSAGE = "사다리의 높이는 숫자여야 합니다.";
    private final String NAME_DELIMITER = ",";
    private final String PRIZE_DELIMITER = ",";
    private final Scanner scanner = new Scanner(System.in);

    private InputView() { }

    public static InputView getInputView() {
        return inputView;
    }

    public List<String> readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        String line = scanner.nextLine();
        return Parser.parse(line, NAME_DELIMITER);
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
        return Parser.parse(line, PRIZE_DELIMITER);
    }
}
