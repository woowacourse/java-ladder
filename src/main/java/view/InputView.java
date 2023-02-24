package view;

import utils.Parser;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ITEM_INPUT_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String TARGET_INPUT_MESSAGE = "\n결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        printMessage(NAME_INPUT_MESSAGE);
        String inputNames = scanner.nextLine();
        return Parser.parse(inputNames, DELIMITER);
    }

    public List<String> readItems() {
        printMessage(ITEM_INPUT_MESSAGE);
        String inputItems = scanner.nextLine();
        return Parser.parse(inputItems, DELIMITER);
    }

    public int readLadderHeight() {
        printMessage(HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine();
        validateDigit(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    public String readTarget() {
        printMessage(TARGET_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    private void validateDigit(String ladderHeight) {
        if (!Pattern.matches(DIGIT_REGEX, ladderHeight)) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
