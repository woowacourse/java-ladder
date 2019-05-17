package ladderGame.model.input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PlayerNamesInput {
    private static final String SEPERATOR = ",";
    private final List<String> names;

    public PlayerNamesInput(String input) throws Exception {
        input = input.replace(" ", "");
        List<String> names = Arrays.asList(input.split(SEPERATOR));
        for (String name : names
        ) {
            checkLength(name);
        }
        checkRepetition(names);
        this.names = names;
    }

    private void checkLength(String name) throws Exception {
        int nameLength = name.length();
        if (nameLength > 5 || nameLength < 1) {
            throw new Exception("이름 길이는 1이상 5이하여야 합니다.");
        }
    }

    private void checkRepetition(List<String> names) throws Exception {
        HashSet<String> namesWithOutRepetition = new HashSet<>(names);
        if (names.size() != namesWithOutRepetition.size()) {
            throw new Exception("중복된 이름이 존재합니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
