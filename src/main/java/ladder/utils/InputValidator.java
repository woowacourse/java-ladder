package ladder.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String DUPLICATE_NAME_MSG = "중복된 이름이 있습니다. 입력한 값 : ";
    private static final String WRONG_NAME_LENGTH_MSG = "이름의 길이가 잘못되었습니다.  입력한 값 : ";
    private static final String NOT_NATURAL_NUMBER = "0보다 큰 값을 입력해 주세요.  입력한 값 : ";
    private static final String UNACCEPTABLE_NAME = "사용할 수 없는 이름 입니다.";
    private static final String SPLIT_SEPARATOR = ",";
    private static final String LENGTH_REGEX = "[a-zA-Z0-9]{1,5}((,)([a-zA-Z0-9]){1,5}){0,}";

    public static void checkValidNames(String input) {
        isWrongLength(input);
        isDuplicated(input);
        isWrongName(input);
    }

    private static void isWrongName(String input) {
        String[] names = splitComponent(input);
        for (String name : names) {
            checkNameFormat(name);
        }
    }

    private static void checkNameFormat(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException(UNACCEPTABLE_NAME);
        }
    }

    public static void isWrongLength(String component) {
        if (!Pattern.matches(LENGTH_REGEX, component)) {
            throw new IllegalArgumentException(WRONG_NAME_LENGTH_MSG + component);
        }
    }

    private static void isDuplicated(String input) {
        String[] names = splitComponent(input);
        Set<String> notDuplicateNames = handleDuplicateName(names);
        if (names.length != notDuplicateNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MSG + input);
        }
    }

    private static Set<String> handleDuplicateName(String[] components) {
        Set<String> notDuplicateComponents = new HashSet<>();
        for (int i = 0; i < components.length; i++) {
            notDuplicateComponents.add(components[i]);
        }
        return notDuplicateComponents;
    }

    private static String[] splitComponent(String component) {
        return component.split(SPLIT_SEPARATOR);
    }

    public static void checkPositive(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER + height);
        }
    }
}
