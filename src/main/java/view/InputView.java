package view;

import domain.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> inputUsernames() {
        String usernames = scanner.nextLine();

        List<String> allUsernames = Arrays.asList(
                usernames.split(DELIMITER));

        inputValidator.validateUsername(allUsernames);

        return allUsernames;
    }

    public int inputHeight() {
        String height = scanner.nextLine().strip();

        inputValidator.validateHeight(height);

        return Integer.parseInt(height);
    }

    public List<String> inputRewards() {
        String rewards = scanner.nextLine();
        List<String> allRewards = Arrays.stream(rewards.split(DELIMITER))
                .map(String::strip)
                .collect(Collectors.toList());

        inputValidator.validateRewardsLength(allRewards);

        return allRewards;
    }

    public String inputChoiceUser() {
        return scanner.nextLine().strip();
    }


}
