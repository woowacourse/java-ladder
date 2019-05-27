package ladderGameSolo.view;

import ladderGameSolo.constant.MessageConstants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Pattern REGEX_NAME = Pattern.compile("^([a-zA-Zㄱ-ㅎ가-힣0-9]{1,5}){1}(,[a-zA-Zㄱ-ㅎ가-힣0-9]{1,5}){1,}$");
    private static final Pattern REGEX_HEIGHT = Pattern.compile("([0-9]){1,}");

    public static String inputName() {
        String name;

        do {
            System.out.println(MessageConstants.INPUT_NAME);
            name = SCAN.nextLine();
        } while (inputValidate(name));

        return name;
    }

    private static boolean inputValidate(String name) {
        return validName(name) || overlapName(name);

    }

    public static int inputHeight() {
        System.out.println(MessageConstants.INPUT_HEIGHT);
        String height = SCAN.nextLine();

        if (!validHeight(height)) {
            System.err.println(MessageConstants.ERROR_INPUT);
            return inputHeight();
        }

        return Integer.parseInt(height);
    }

    public static String inputResult(int memberSize) {
        System.out.println(MessageConstants.INPUT_RESULT);
        String result = SCAN.nextLine();

        if (validGameResult(result) || isNotSameLength(memberSize, result)) {
            return inputResult(memberSize);
        }

        return result;
    }

    public static String inputTargetName(String[] names) {
        System.out.println(MessageConstants.INPUT_TARGET);
        String target = SCAN.nextLine();

        if (isBlank(target) || isNotInName(target, names)) {
            return inputTargetName(names);
        }

        return target;
    }

    private static boolean isNotInName(String target, String[] names) {
        int count = 0;

        count = getCount(target, names, count);

        if (count == 0 && !target.equals(MessageConstants.MESSAGE_ALL)) {
            System.err.println(MessageConstants.ERROR_NOT_EXIST_MEMBER);
            return true;
        }

        return false;
    }

    private static int getCount(String target, String[] names, int count) {
        for (String name : names) {
            count += findSameName(target, name);
        }
        return count;
    }

    private static int findSameName(String target, String name) {
        if (name.equals(target)) {
            return 1;
        }
        return 0;
    }

    private static boolean validGameResult(String result) {
        return isBlank(result) || hasNotComma(result);
    }

    private static boolean isNotSameLength(int memberSize, String target) {
        String[] targets = target.split(MessageConstants.DELIMITER_COMMA);

        if (memberSize != targets.length) {
            System.err.println(MessageConstants.ERROR_INPUT_RESULT);
            return true;
        }

        return false;
    }

    private static boolean isBlank(String text) {
        if (text.isEmpty()) {
            System.err.println(MessageConstants.ERROR_EMPTY);
            return true;
        }

        return false;
    }

    private static boolean hasNotComma(String text) {
        if (!text.contains(MessageConstants.DELIMITER_COMMA)) {
            System.err.println(MessageConstants.ERROR_COMMA);
            return true;
        }

        return false;
    }

    private static boolean validName(String name) {
        Matcher matcher = REGEX_NAME.matcher(name);
        if (!matcher.matches()) {
            System.err.println(MessageConstants.ERROR_INPUT);
            return true;
        }
        return false;
    }

    private static boolean overlapName(String name) {
        String[] inputName = name.split(MessageConstants.DELIMITER_COMMA);
        Set<String> names = new HashSet<>(Arrays.asList(inputName));

        if (names.size() != inputName.length) {
            System.err.println(MessageConstants.ERROR_DUPLICATE_NAME);
            return true;
        }

        return false;
    }

    private static boolean validHeight(String height) {
        Matcher matcher = REGEX_HEIGHT.matcher(height);

        return matcher.matches();
    }
}
