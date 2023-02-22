package domain;

import static exception.ErrorMessage.RESULT_NAME_BLANK_EXCEPTION;
import static exception.ErrorMessage.RESULT_NAME_LENGTH_EXCEPTION;

public class Result {

    private final String name;

    public Result(final String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.length() > 8) {
            throw new IllegalArgumentException(RESULT_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(RESULT_NAME_BLANK_EXCEPTION.getMessage());
        }
    }
}
