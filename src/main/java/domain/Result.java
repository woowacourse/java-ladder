package domain;

import exception.InvalidResultNameException;
import util.StringUtil;

import java.util.Objects;

public class Result {

    private static final int MAX_NAME_LENGTH = 5;

    private final String result;

    public Result(String result) {
        validateResult(result);
        result = result.trim();
        this.result = result;
    }

    private void validateResult(String result) {
        if (isValidLength(result)) {
            throw new InvalidResultNameException();
        }
    }

    private boolean isValidLength(String result) {
        return StringUtil.isNullOrBlank(result) || result.trim().length() > MAX_NAME_LENGTH;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
