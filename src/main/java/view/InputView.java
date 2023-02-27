package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static utils.ErrorMessage.*;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUsernames() {
        String usernames = scanner.nextLine();
        return Arrays.asList(usernames.split(DELIMITER));
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
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_INPUT.getMessage());
        }
    }

}
