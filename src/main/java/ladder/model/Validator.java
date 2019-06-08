package ladder.model;

import ladder.view.InputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String SEPARATOR_REGEX = "([0-9a-zA-Z가-힣]+,)*([0-9a-zA-Z가-힣]+)";
    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern p = Pattern.compile(SEPARATOR_REGEX);

    public static void checkInput(String names) {
        checkSeparator(names);
        checkInputsLength(names);
    }

    private static void checkSeparator(String names) {
        Matcher m = p.matcher(names);
        if (!m.matches()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputsLength(String names) {
        for (String name : names.split(InputView.SEPERATOR)) {
            checkEachInputLength(name);
        }
    }

    private static void checkEachInputLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMemberCount(int countOfResults, int countOfMember) {
        if (countOfResults != countOfMember) {
            throw new IllegalArgumentException();
        }
    }

}
