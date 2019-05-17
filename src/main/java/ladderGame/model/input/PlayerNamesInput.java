package ladderGame.model.input;

import java.util.Arrays;
import java.util.List;

public class PlayerNamesInput {
    private static final String SEPERATOR = ",";

    public PlayerNamesInput(String input) throws Exception {
        List<String> names = Arrays.asList(trimSpaces(input).split(SEPERATOR));
        for (String name : names
             ) {
            int nameLength = name.length();
            if (nameLength > 5 || nameLength < 1) {
                throw new Exception("이름 길이는 1이상 5이하여야 합니다.");
            }
        }
    }

    private String trimSpaces(String input) {
        return input.replace(" ", "");
    }
}
