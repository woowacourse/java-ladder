package ladderGame.model.input;

import java.util.Arrays;
import java.util.List;

public class ResultsInput {
    private static final String SEPERATOR = ",";
    private final String input;

    public ResultsInput(String input, PlayerNamesInput playerNamesInput) throws Exception {
        input = input.replace(" ", "");
        List<String> names = Arrays.asList(input.split(SEPERATOR));
        for (String name : names
        ) {
            checkLength(name);
        }
        compareNamesAndResultsSize(playerNamesInput, names);
        this.input = input;
    }

    private void compareNamesAndResultsSize(PlayerNamesInput playerNamesInput, List<String> names) throws Exception {
        if(playerNamesInput.getNames().size() != names.size()) {
            throw new Exception("결과들 개수는 전 이름들 입력 개수와 같아야 합니다.");
        }
    }

    private void checkLength(String name) throws Exception {
        int nameLength = name.length();
        if (nameLength > 5 || nameLength < 1) {
            throw new Exception("이름 길이는 1이상 5이하여야 합니다.");
        }
    }

}
