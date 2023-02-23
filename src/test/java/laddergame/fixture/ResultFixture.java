package laddergame.fixture;

import laddergame.domain.Result;

public abstract class ResultFixture {
    public static Result createResult(final String value) {
        return new Result(value);
    }
}
