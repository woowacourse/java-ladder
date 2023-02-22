package ladder.domain;

public class Reward {

    private static final String NO_LUCK = "꽝";
    private static final String RESULT_EXCEPT_NO_LUCK_IS_NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] \"꽝\" 이외의 실행 결과는 정수여야합니다.";
    private static final int MIN_RUN_RESULT_VALUE = 1;
    private static final int MAX_RUN_RESULT_VALUE = 10000;
    private static final String RESULT_EXCEPT_NO_LUCK_IS_WRONG_RANGE_ERROR_MESSAGE = "[ERROR] \"꽝\" 이외의 실행 결과는 1 이상 10000 이하의 정수여야합니다.";


    private final String reward;
    private final int index;

    public Reward(String reward, int index) {
        validate(reward);
        this.reward = reward;
        this.index = index;
    }

    private void validate(String runResult) {
        if (isNotNoLuck(runResult)) {
            validateNumeric(runResult);
            validateRange(runResult);
        }
    }

    private boolean isNotNoLuck(String runResult) {
        return !NO_LUCK.equals(runResult);
    }

    private void validateNumeric(String runResult) {
        try {
            Integer.parseInt(runResult);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RESULT_EXCEPT_NO_LUCK_IS_NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private void validateRange(String runResult) {
        int parsedRunResult = Integer.parseInt(runResult);
        if (isRunResultWrongRange(parsedRunResult)) {
            throw new IllegalArgumentException(RESULT_EXCEPT_NO_LUCK_IS_WRONG_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isRunResultWrongRange(int runResult) {
        return runResult < MIN_RUN_RESULT_VALUE || runResult > MAX_RUN_RESULT_VALUE;
    }

    public boolean isSameRewardIndex(int rewardIndex) {
        return this.index == rewardIndex;
    }
}
