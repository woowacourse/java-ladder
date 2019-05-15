package ladder.validator;

import java.util.Arrays;
import java.util.HashSet;

public class InputValidator {
    static String isEmpty(String names) {
        if (names == null || names.length() == 0) {
            throw new IllegalArgumentException("양식에 맞는 이름을 입력해주세요.");
        }
        return names;
    }

    static String hasSpace(String names) {
        if (names.contains(" ")) {
            throw new IllegalArgumentException("양식에 맞는 이름을 입력해주세요.");
        }
        return names;
    }

    static void isOverMaxNameLimit(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("양식에 맞는 이름을 입력해주세요.");
        }
    }

    static void isDuplicate(String[] name) {
        HashSet<String> names = new HashSet<>(Arrays.asList(name));
        if (names.size() != name.length) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

    static void checkLastIndex(String names) {
        if (names.lastIndexOf(",") == names.length() - 1) {
            throw new IllegalArgumentException("양식에 맞는 이름을 입력해주세요.");
        }
    }
}



