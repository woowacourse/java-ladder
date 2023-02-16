package view;

import utils.Parser;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

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
        validateHeightRange(Integer.valueOf(ladderHeight));
        return Integer.valueOf(ladderHeight);
    }

    private void validateDigit(String ladderHeight) {
        if (!Pattern.matches(DIGIT_REGEX ,ladderHeight)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateHeightRange(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
