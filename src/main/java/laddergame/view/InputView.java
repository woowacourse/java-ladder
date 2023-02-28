package laddergame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import laddergame.utils.ErrorMessage;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUserNames() {
        String userNames = scanner.nextLine();
        
        return Arrays.asList(userNames.split(DELIMITER));
    }

    public List<String> inputGameResults() {
        String gameResults = scanner.nextLine();

        return Arrays.asList(gameResults.split(DELIMITER));
    }

    public int inputHeight() {
        String height = scanner.nextLine();

        validateHeightInput(height);

        return Integer.parseInt(height);
    }

    public String inputUserToCheckResult() {
        return scanner.nextLine();
    }

    private void validateHeightInput(String height) {
        try {
            Integer.parseInt(height);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_HEIGHT_INPUT.getMessage());
        }
    }

}
