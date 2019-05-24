package ladder.model.validator;

import java.util.regex.Pattern;

public class MemberValidator {

    private static final Pattern SEPARATOR_REGEX_PATTERN = Pattern.compile("([0-9a-zA-Z가-힣]+,)*([0-9a-zA-Z가-힣]+)");

    public static boolean checkSeparator(String names) {
        return SEPARATOR_REGEX_PATTERN.matcher(names).matches();
    }

    public static void checkMemberCount(int countOfResults, int countOfMember) {
        if (countOfResults != countOfMember) {
            throw new IllegalArgumentException();
        }
    }
}
