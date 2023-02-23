package domain;

import java.util.List;

import static utils.ErrorMessage.*;

public class InputValidator {

    private static final int MINIMUM_USER_NUMBER_LIMIT = 1;
    private static final int MAXIMUM_USER_NUMBER_LIMIT = 20;
    private static final int MAXIMUM_REWARD_LENGTH_LIMIT = 5;
    private static final int MINIMUM_REWARD_LENGTH_LIMIT = 1;

    public void validateRewardsLength(List<String> rewards) {
        for (String reward : rewards) {
            validateRewardLengthByMaximumLimit(reward);
            validateRewardLengthByMinimumLimit(reward);
        }
    }

    public void validateHeight(String height) {
        try {
            Integer.parseInt(height);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_INPUT.getMessage());
        }
    }

    public void validateUsername(List<String> allUsernames) {
        validateUsernameDuplication(allUsernames);
        validateUsernamesNumberByMinimumLimit(allUsernames);
        validateUsernamesNumberByMaximumLimit(allUsernames);
    }

    private void validateRewardLengthByMaximumLimit(String reward) {
        if (reward.length() > MAXIMUM_REWARD_LENGTH_LIMIT) {
            throw new IllegalArgumentException(
                    String.format(
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

    private void validateUsernamesNumberByMinimumLimit(List<String> allUsernames) {
        if (allUsernames.size() < MINIMUM_USER_NUMBER_LIMIT) {
            throw new IllegalArgumentException(
                    String.format(
                            INVALID_USER_NUMBER_NUMBER_BY_MINIMUM_LIMIT.getMessage(),
                            MINIMUM_USER_NUMBER_LIMIT));
        }
    }

    private void validateUsernamesNumberByMaximumLimit(List<String> allUsernames) {
        if (allUsernames.size() > MAXIMUM_USER_NUMBER_LIMIT) {
            throw new IllegalArgumentException(
                    String.format(
                            INVALID_USER_NUMBER_NUMBER_BY_MAXIMUM_LIMIT.getMessage(),
                            MAXIMUM_USER_NUMBER_LIMIT));
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
