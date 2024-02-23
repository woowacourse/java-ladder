package view;

import domain.LadderHeight;
import domain.Name;

import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String NAME_SPLIT_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<Name> readNames() {
        String names = scanner.nextLine();
        String[] splitNames = names.split(NAME_SPLIT_DELIMITER);

        return Arrays.stream(splitNames)
                .map(Name::new)
                .toList();
    }

    public LadderHeight readLadderHeight() {
        String input = scanner.nextLine();
        int value = convertToInteger(input);
        return new LadderHeight(value);
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 정수로 입력해야 합니다.");
        }
    }
}
