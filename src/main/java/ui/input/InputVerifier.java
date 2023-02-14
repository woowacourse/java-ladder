package ui.input;

import java.util.Arrays;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
class InputVerifier {

//    protected static void validateName() {
//        validateNameLength();
//
//    }

    protected static void validateNameLength(String input) {
        List<String> names = splitInput(input);
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 최대 5글자 까지만 입력할 수 있습니다.");
            }
        }
    }

    private static List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }
}
