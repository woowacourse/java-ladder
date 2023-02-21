package domain;

import exception.EmpytInputException;
import exception.InvalidLadderResultException;

public class LadderResult {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    private final String resultName;

    public LadderResult(String resultName) {
        validate(resultName);
        this.resultName = resultName;
    }

    private void validate(String resultName) {
        if (isBlank(resultName)) {
            throw new EmpytInputException();
        }
        if (isInvalidLength(resultName)) {
            throw new InvalidLadderResultException();
        }
    }

    private boolean isBlank(String results) {
        return results == null || results.isBlank();
    }

    private boolean isInvalidLength(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    public String getName() {
        return resultName;
    }
}
