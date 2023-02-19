package view;

import static utils.ErrorMessage.INVALID_LADDER_HEIGHT_INPUT;
import static utils.ErrorMessage.INVALID_USER_NUMBER_NUMBER_BY_MAXIMUM_LIMIT;
import static utils.ErrorMessage.INVALID_USER_NUMBER_NUMBER_BY_MINIMUM_LIMIT;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String DELIMITER = ",";
    private final int MINIMUM_USER_NUMBER_LIMIT = 1;
    private final int MAXIMUM_USER_NUMBER_LIMIT = 100;

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUserNames() {
        String userNames = scanner.nextLine();
        List<String> allUserNames = Arrays.asList(
            userNames.split(DELIMITER));

        validateUserNamesNumberByMinimumLimit(allUserNames);
        validateUserNamesNumberByMaximumLimit(allUserNames);

        return allUserNames;
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

    private void validateUserNamesNumberByMinimumLimit(List<String> allUserNames) {
        if (allUserNames.size() < MINIMUM_USER_NUMBER_LIMIT) {
            throw new IllegalArgumentException(
                String.format(
                INVALID_USER_NUMBER_NUMBER_BY_MINIMUM_LIMIT.getMessage(),
                    MINIMUM_USER_NUMBER_LIMIT));
        }
    }

    private void validateUserNamesNumberByMaximumLimit(List<String> allUserNames) {
        if (allUserNames.size() > MAXIMUM_USER_NUMBER_LIMIT) {
            throw new IllegalArgumentException(
                String.format(
                INVALID_USER_NUMBER_NUMBER_BY_MAXIMUM_LIMIT.getMessage(),
                    MAXIMUM_USER_NUMBER_LIMIT));
        }
    }

}
