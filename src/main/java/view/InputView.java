package view;

import static utils.ErrorMessage.INVALID_LADDER_HEIGHT_INPUT;
import static utils.ErrorMessage.INVALID_USER_NUMBER_NUMBER_BY_MAXIMUM_LIMIT;
import static utils.ErrorMessage.INVALID_USER_NUMBER_NUMBER_BY_MINIMUM_LIMIT;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_USER_NUMBER_LIMIT = 1;
    private static final int MAXIMUM_USER_NUMBER_LIMIT = 100;
    private static final int MAXIMUM_REWARD_LENGTH_LIMIT = 5;
    private static final int MINIMUM_REWARD_LENGTH_LIMIT = 1;

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputUserNames() {
        String userNames = scanner.nextLine();
        List<String> allUserNames = Arrays.asList(
            userNames.split(DELIMITER));
        validateUserName(allUserNames);

        return allUserNames;
    }

    public int inputHeight() {
        String height = scanner.nextLine();

        validateHeightInput(height);

        return Integer.parseInt(height);
    }

    public List<String> inputResults() {
        String results = scanner.nextLine();
        return Arrays.asList(
            results.split(DELIMITER));
    }

    // TODO: 2023/02/20 메서드 명 변경
    public String inputFinalChoice() {
        return scanner.nextLine().strip();
    }

    private void validateRewardsLength(List<String> rewards) {
        for (String reward : rewards) {
            validateRewardLengthByMaximumLimit(reward);
            validateRewardLengthByMinimumLimit(reward);
        }
    }

    private void validateRewardLengthByMaximumLimit(String reward) {
        if (reward.length() > MAXIMUM_REWARD_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format(
                INVALID_REWARD_LENGTH_BY_MAXIMUM_LIMIT.getMessage()
                , MAXIMUM_REWARD_LENGTH_LIMIT));
        }
    }

    private void validateRewardLengthByMinimumLimit(String reward) {
        if (reward.length() < MINIMUM_REWARD_LENGTH_LIMIT) {
            throw new IllegalArgumentException(
                String.format(
                    INVALID_REWARD_LENGTH_BY_MINIMUM_LIMIT.getMessage(),
                    MINIMUM_REWARD_LENGTH_LIMIT));
        }
    }

    private void validateHeightInput(String height) {
        try {
            Integer.parseInt(height);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_INPUT.getMessage());
        }
    }

    private void validateUserName(List<String> allUserNames) {
        validateUserNameDuplication(allUserNames);
        validateUserNamesNumberByMinimumLimit(allUserNames);
        validateUserNamesNumberByMaximumLimit(allUserNames);
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

    private void validateUserNameDuplication(List<String> allUserNames) {
        if (allUserNames.size() != checkDistinctSize(allUserNames)) {
            throw new IllegalArgumentException(
                DUPLICATE_USER_NAME.getMessage());
        }
    }

    private long checkDistinctSize(List<String> allUserNames) {
        return allUserNames.stream()
            .distinct()
            .count();
    }

}
