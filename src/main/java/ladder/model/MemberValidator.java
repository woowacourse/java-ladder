package ladder.model;

public class MemberValidator {

    private static final String SEPARATOR_REGEX = "([0-9a-zA-Z가-힣]+,)*([0-9a-zA-Z가-힣]+)";
    private static final int MAX_NAME_LENGTH = 5;

    public static void checkSeparator(String names) {
        if (!names.matches(SEPARATOR_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNamesLength(String[] names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    public static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
