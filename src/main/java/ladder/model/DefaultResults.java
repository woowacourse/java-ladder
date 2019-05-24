package ladder.model;

import java.util.List;

public class DefaultResults {
    private final List<Result> defaultResult;

    public DefaultResults(final List<Result> defaultResult) {
        this.defaultResult = defaultResult;
    }

    Result getResult(final int position) {
        return defaultResult.get(position);
    }
}
