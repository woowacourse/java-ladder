package ladder.model.validator;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern SEPARATOR_REGEX_PATTERN = Pattern.compile("([0-9a-zA-Z가-힣]+,)*([0-9a-zA-Z가-힣]+)");
    public static final int MIN_HEIGHT = 1;

    public static boolean validSeparator(String names) {
        return SEPARATOR_REGEX_PATTERN.matcher(names).matches();
    }

    public static boolean validMemberCount(int countOfResults, int countOfMember) {
        return countOfResults != countOfMember;
    }

    public static boolean validHeight(int height) {
        return height < MIN_HEIGHT;
    }

    public static boolean validResultsName(List<String> membersName, final String inputName) {
        return "all".equals(inputName) || membersName.stream().anyMatch(name -> name.equals(inputName));
    }
}
