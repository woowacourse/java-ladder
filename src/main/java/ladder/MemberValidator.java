package ladder;

public class MemberValidator {

    public static final String SEPERATOR_REGEX = "([0-9a-zA-Z가-힣]+,)*([0-9a-zA-Z가-힣]+)";
    private static final int MAX_NAME_LENGTH = 5;

    public static void checkSeperator(String names) {
        if (!names.matches(SEPERATOR_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
