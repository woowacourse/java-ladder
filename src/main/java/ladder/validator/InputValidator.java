package ladder.validator;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {
    private static final int MIN_HEIGHT = 1;
    private static final String EXCEPTION_MESSAGE = "양식에 맞게 입력해 주세요.";
    static String isEmpty(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return input;
    }

    static String hasSpace(String inputs) {
        if (inputs.contains(" ")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return inputs;
    }

    static void isOverMaxInputLimit(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    static void isDuplicate(String[] name) {
        HashSet<String> names = new HashSet<>(Arrays.asList(name));
        if (names.size() != name.length) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

    static void checkLastIndex(String inputs) {
        if (inputs.lastIndexOf(",") == inputs.length() - 1) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    static void isLowerLimit(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
    }

    static void isSameLength(String[] names, String[] results) {
        if (names.length != results.length) {
            throw new IllegalArgumentException("결과의 개수는 %d개가 필요합니다.");
       }
    }
}



