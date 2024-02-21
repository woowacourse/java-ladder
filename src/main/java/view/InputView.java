package view;

import domain.LadderHeight;
import domain.Name;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NAME_SPLIT_DELIMITER = ",";

    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public List<Name> readNames() {
        String names = reader.readLine();
        String[] splitNames = names.split(NAME_SPLIT_DELIMITER);

        return Arrays.stream(splitNames)
                .map(Name::new)
                .toList();
    }

    public LadderHeight readLadderHeight() {
        String input = reader.readLine();
        int value = convertToInteger(input);
        return new LadderHeight(value);
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 1 이상 10 이하의 정수여야 합니다.");
        }
    }
}
