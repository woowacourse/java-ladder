package domain;

import exception.InvalidResultNameException;
import util.StringUtil;

public class Result {

    private static final int MAX_NAME_LENGTH = 5;

    private final String result;

    public Result(String result) {
        validateResult(result);
        this.result = result;
    }

    private void validateResult(String result) {
        if (isValidLength(result)) {
            throw new InvalidResultNameException();
        }
    }

    private boolean isValidLength(String result) {
        return StringUtil.isNullOrBlank(result) || result.length() > MAX_NAME_LENGTH;
    }

    public String getResult() {
        return result;
    }
}
