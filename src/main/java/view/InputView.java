package view;

import utils.ErrorMessage;
import utils.Parser;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        printMessage(NAME_INPUT_MESSAGE);
        String inputNames = scanner.nextLine();
        return Parser.parse(inputNames, DELIMITER);
    }

    public int readLadderHeight() {
        printMessage(HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine();
        validateDigit(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private void validateDigit(String ladderHeight) {
        if (!Pattern.matches(DIGIT_REGEX, ladderHeight)) {
            throw new IllegalArgumentException(ErrorMessage.DIGIT_ERROR.getMessage());
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
