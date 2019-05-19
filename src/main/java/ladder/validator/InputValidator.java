package ladder.validator;

import ladder.domain.Person;
import ladder.util.InputHelper;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static String NOT_CONTAIN_NAME_MESSAGE = "없는 이름입니다.";
    public static String isNotContainName(Person person, String requestedName) {
        if (!requestedName.equals("all") && !person.findName(requestedName)) {
            throw new IllegalArgumentException(NOT_CONTAIN_NAME_MESSAGE);
        }
        return requestedName;
    }
}



