package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static utils.ErrorMessage.*;

public class InputView {
    private static final int MINIMUM_USER_NUMBER = 1;
    private static final int MAXIMUM_USER_NUMBER = 20;
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUsernames() {
        String usernames = scanner.nextLine();
        List<String> allUsernames = Arrays.asList(
                usernames.split(DELIMITER));

        validateUsernameDuplication(allUsernames);
        validateUsernamesNumber(allUsernames);

        return allUsernames;
    }

    public int inputHeight() {
        String height = scanner.nextLine().strip();

        validateHeight(height);

        return Integer.parseInt(height);
    }

    public List<String> inputRewards() {
        String rewards = scanner.nextLine();
        return Arrays.stream(rewards.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public String inputChoiceUser() {
        return scanner.nextLine().strip();
    }

    private void validateHeight(String height) {
        try {
            Integer.parseInt(height);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_INPUT.getMessage());
        }
    }

    private void validateUsernamesNumber(List<String> allUsernames) {
        if (allUsernames.size() < MINIMUM_USER_NUMBER || allUsernames.size() > MAXIMUM_USER_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(
                            INVALID_USER_NUMBER.getMessage(),
                            MINIMUM_USER_NUMBER, MAXIMUM_USER_NUMBER));
        }
    }

    private void validateUsernameDuplication(List<String> allUsernames) {
        if (allUsernames.size() != checkDistinctSize(allUsernames)) {
            throw new IllegalArgumentException(
                    DUPLICATE_USERNAME.getMessage());
        }
    }

    private long checkDistinctSize(List<String> allUsernames) {
        return allUsernames.stream()
                .distinct()
                .count();
    }

}
