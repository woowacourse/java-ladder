package view;

import exception.BlankInputException;
import exception.WrongDelimiterException;
import exception.WrongNumberFormatException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputNameOfParticipants() {
        String names = scanner.nextLine();

        validateBlank(names);
        validateDelimiter(names);

        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDelimiter(String names) {
        if (!names.contains(DELIMITER)) {
            throw new WrongDelimiterException();
        }
    }

    public int inputHeightOfLadder() {
        String inputHeight = scanner.nextLine();

        validateBlank(inputHeight);
        return mapToHeightNumber(inputHeight);
    }

    private int mapToHeightNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new WrongNumberFormatException();
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new BlankInputException();
        }
    }
}
