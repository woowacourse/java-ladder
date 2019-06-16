package ladder.view;

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
    private static final String EXCEPTION_WRONG_INPUT;
    private static final String EXCEPTION_MIN_MEMBERS;
    private static final int MAX_NAME_LENGTH;
    private static final int MIN_NAMES_COUNT;

    static {
        SCANNER = new Scanner(System.in);
        MAX_NAME_LENGTH = 5;
        MIN_NAMES_COUNT = 2;
        DELIMITER = ",\\s*";
        EXCEPTION_WRONG_INPUT = "입력값이 잘못되었습니다.";
        EXCEPTION_NUMBER_RANGE = "1 이상의 숫자를 입력해주세요.";
        EXCEPTION_NOT_NUMBER = "숫자를 입력해주세요.";
        EXCEPTION_MIN_MEMBERS = "참여할 사람은 최소 2명 이상이어야 합니다.";
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

    private static List<String> tryInput(String message) {
        try {
            List<String> input = getInputStringList(message);
            checkInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return tryInput(message);
        }
    }

    public static List<String> names() {
        return tryInput(MESSAGE_INPUT_NAME);
    }

    public static List<String> outcomes(List<String> names) {
        try {
            List<String> input = tryInput(MESSAGE_INPUT_RESULT);
            checkInput(input);
            checkMemberCount(input.size(), names.size());
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return outcomes(names);
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

    private static void checkInput(List<String> names) {
        if (names.size() < MIN_NAMES_COUNT) {
            throw new IllegalArgumentException(EXCEPTION_MIN_MEMBERS);
        }
        for (String name : names) {
            checkEachInputLength(name);
        }
    }

    private static void checkEachInputLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_INPUT);
        }
    }

    private static void checkMemberCount(int countOfResults, int countOfMember) {
        if (countOfResults != countOfMember) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_INPUT);
        }
    }
}
