package ladderGameSolo.view;

import ladderGameSolo.constant.MessageContants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String REGEX_NAME = "^([a-zA-Zㄱ-ㅎ가-힣0-9]{1,5}){1}(,[a-zA-Zㄱ-ㅎ가-힣0-9]{1,5}){1,}$";
    private static final String REGEX_HEIGHT = "([0-9]){1}";

    public static String inputName() {
        System.out.println(MessageContants.INPUT_NAME);
        String name = SCAN.nextLine();

        if (!validName(name) || overlapName(name)) {
            System.err.println(MessageContants.ERROR_INPUT);
            return inputName();
        }

        return name;
    }

    public static int inputHeight() {
        System.out.println(MessageContants.INPUT_HEIGHT);
        String height = SCAN.nextLine();

        if (!validHeight(height)) {
            System.err.println(MessageContants.ERROR_INPUT);
            return inputHeight();
        }

        return Integer.parseInt(height);
    }

    public static String inputResult(int memberSize) {
        System.out.println(MessageContants.INPUT_RESULT);
        String result = SCAN.nextLine();

        if (validGameResult(result) || isNotSameLength(memberSize, result)) {
            return inputResult(memberSize);
        }

        return result;
    }

    public static String inputTargetName(String[] names) {
        System.out.println(MessageContants.INPUT_TARGET);
        String target = SCAN.nextLine();

        if (isBlank(target) || isNotInName(target, names)) {
            return inputTargetName(names);
        }

        return target;
    }

    private static boolean isNotInName(String target, String[] names) {
        int count = 0;

        count = getCount(target, names, count);

        if (count == 0 && !target.equals(MessageContants.MESSAGE_ALL)) {
            System.err.println(MessageContants.ERROR_NOT_EXIST_MEMBER);
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
        String[] targets = target.split(MessageContants.DELIMITER_COMMA);

        if (memberSize != targets.length) {
            System.err.println(MessageContants.ERROR_INPUT_RESULT);
            return true;
        }

        return false;
    }

    private static boolean isBlank(String text) {
        if (text.isEmpty()) {
            System.err.println(MessageContants.ERROR_EMPTY);
            return true;
        }

        return false;
    }

    private static boolean hasNotComma(String text) {
        if (!text.contains(MessageContants.DELIMITER_COMMA)) {
            System.err.println(MessageContants.ERROR_COMMA);
            return true;
        }

        return false;
    }

    private static boolean validName(String name) {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    private static boolean overlapName(String name) {
        String[] inputName = name.split(MessageContants.DELIMITER_COMMA);
        Set<String> names = new HashSet<>(Arrays.asList(inputName));

        if (names.size() != inputName.length) {
            System.err.println(MessageContants.ERROR_DUPLICATE_NAME);
            return true;
        }

        return false;
    }

    private static boolean validHeight(String height) {
        Pattern pattern = Pattern.compile(REGEX_HEIGHT);
        Matcher matcher = pattern.matcher(height);

        return matcher.matches();
    }
}
