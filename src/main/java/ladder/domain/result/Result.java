package ladder.domain.result;

import ladder.domain.result.exception.ResultNameLengthException;

public class Result {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    private Result(String name) {
        this.name = name;
    }

    public static Result from(String name) {
        validateName(name);
        return new Result(name);
    }

    private static void validateName(final String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new ResultNameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
