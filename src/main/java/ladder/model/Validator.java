package ladder.model;

import java.util.List;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String EXCEPTION_WRONG_INPUT = "입력값이 잘못되었습니다.";

    public static void checkInput(List<String> names) {
        for (String name : names) {
            checkEachInputLength(name);
        }
    }

    private static void checkEachInputLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_INPUT);
        }
    }

    public static void checkMemberCount(int countOfResults, int countOfMember) {
        if (countOfResults != countOfMember) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_INPUT);
        }
    }
}
