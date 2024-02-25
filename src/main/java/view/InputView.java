package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NAME_SPLIT_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        String names = scanner.nextLine();
        String[] splitNames = names.split(NAME_SPLIT_DELIMITER);

        return Arrays.stream(splitNames)
                .toList();
    }

    public int readLadderHeight() {
        String input = scanner.nextLine();
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
