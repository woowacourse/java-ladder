package domain;

import static message.ErrorMessage.NO_RESULT_EXCEPTION;

public class Result {

    private final String result;

    public Result(String result) {
        validateResultBlank(result);
        this.result = result;
    }

    private void validateResultBlank(String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException(NO_RESULT_EXCEPTION.getMessageWithCause(result));
        }
    }

    public String getResult() {
        return result;
    }
}
