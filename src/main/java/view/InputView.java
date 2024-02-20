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
        
        return Arrays.asList(splitNames);
    }

    public int readLadderHeight() {
        String input = reader.readLine();
        return convertToInteger(input);
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 1 이상 10 이하의 정수여야 합니다.");
        }
    }
}
