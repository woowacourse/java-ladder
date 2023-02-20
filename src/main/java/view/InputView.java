package view;

import static utils.ErrorMessage.INVALID_LADDER_HEIGHT_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUserNames() {
        String userNames = scanner.nextLine();
        
        return Arrays.asList(userNames.split(DELIMITER));
    }

    public int inputHeight() {
        String height = scanner.nextLine();

        validateHeightInput(height);

        return Integer.parseInt(height);
    }

    private void validateHeightInput(String height) {
        try {
            Integer.parseInt(height);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_INPUT.getMessage());
        }
    }

}
