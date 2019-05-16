package ladder.model;

public class MemberGenerator {

    private static final String COMMA = ",";

    public static String[] splitByComma(String inputText) {
        String[] members = inputText.split(COMMA);
        return members;
    }
}
