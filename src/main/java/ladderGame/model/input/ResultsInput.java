package ladderGame.model.input;

import java.util.Arrays;
import java.util.List;

public class ResultsInput {
    private static final String SEPERATOR = ",";
    private final String input;

    public ResultsInput(String input) throws Exception {

        input = input.replace(" ", "");
        List<String> names = Arrays.asList(input.split(SEPERATOR));
        for (String name : names
        ) {
            checkLength(name);
        }

        this.input = input;
    }

    private void checkLength(String name) throws Exception {
        int nameLength = name.length();
        if (nameLength > 5 || nameLength < 1) {
            throw new Exception("이름 길이는 1이상 5이하여야 합니다.");
        }
    }

}
