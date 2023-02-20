package domain;

import exception.Error;

public class Prize {
    private static final int MIN_RESULT_LENGTH_INCLUSIVE = 1;
    private static final int MAX_RESULT_LENGTH_INCLUSIVE = 5;

    private final String result;

    public Prize(String result) {
        validate(result);

        this.result = result.trim();
    }

    private void validate(String result) {
        result = result.trim();

        if (result.length() < MIN_RESULT_LENGTH_INCLUSIVE || result.length() > MAX_RESULT_LENGTH_INCLUSIVE) {
            throw new IllegalArgumentException(Error.INVALID_RESULT_LENGTH.getMessage());
        }
    }

    public String getResult() {
        return result;
    }
}
