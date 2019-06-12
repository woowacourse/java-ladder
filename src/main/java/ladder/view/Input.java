package ladder.view;

import ladder.model.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER;
    private static final String DELIMITER;
    private static final String MESSAGE_INPUT_NAME;
    private static final String MESSAGE_INPUT_RESULT;
    private static final String MESSAGE_INPUT_HEIGHT;
    private static final String MESSAGE_FIND_RESULT;
    private static final String EXCEPTION_NOT_NUMBER;
    private static final String EXCEPTION_NUMBER_RANGE;

    static {
        SCANNER = new Scanner(System.in);
        DELIMITER = ",\\s*";
        EXCEPTION_NUMBER_RANGE = "1 이상의 숫자를 입력해주세요.";
        EXCEPTION_NOT_NUMBER = "숫자를 입력해주세요.";
        MESSAGE_FIND_RESULT = "결과를 보고 싶은 사람은?";
        MESSAGE_INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
        MESSAGE_INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
        MESSAGE_INPUT_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    }

    private static String getInputString(String message) {
        System.out.println(message);
        return SCANNER.nextLine().strip();
    }

    private static int getInputInt(String message) {
        try {
            return Integer.parseInt(getInputString(message));
        } catch (Exception e) {
            System.err.println(EXCEPTION_NOT_NUMBER);
            return getInputInt(message);
        }
    }

    private static List<String> arrayToList(String[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    private static List<String> inputToList(String rawInput) {
        String[] tokens = rawInput.split(DELIMITER);
        return arrayToList(tokens);
    }

    private static List<String> getInputStringList(String message) {
        return inputToList(getInputString(message));
    }

    public static List<String> names() {
        try {
            List<String> input = getInputStringList(MESSAGE_INPUT_NAME);
            Validator.checkInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return names();
        }
    }

    public static List<String> results(int countOfMember) {
        try {
            List<String> input = getInputStringList(MESSAGE_INPUT_RESULT);
            Validator.checkInput(input);
            Validator.checkMemberCount(input.size(), countOfMember);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return results(countOfMember);
        }
    }

    public static int ladderHeight() {
        try {
            int ladderHeight = getInputInt(MESSAGE_INPUT_HEIGHT);
            checkLadderHeight(ladderHeight);
            return ladderHeight;
        } catch (IllegalArgumentException e) {
            System.err.println(EXCEPTION_NUMBER_RANGE);
            return ladderHeight();
        }
    }

    private static void checkLadderHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_RANGE);
        }
    }

    public static String memberResult() {
        return getInputString(MESSAGE_FIND_RESULT);
    }
}
