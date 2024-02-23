package view;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NAME_SPLIT_DELIMITER = ",";

    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public List<String> readNames() {
        String names = reader.readLine();
        String[] splitNames = names.split(NAME_SPLIT_DELIMITER);

        return Arrays.stream(splitNames)
                .toList();
    }

    public int readLadderHeight() {
        String input = reader.readLine();
        return convertToInteger(input);
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 정수로 입력해야 합니다.");
        }
    }
}
