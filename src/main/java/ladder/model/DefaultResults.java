package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultResults {
    private final List<Result> defaultResult;

    public DefaultResults(final List<Result> defaultResult) {
        this.defaultResult = new ArrayList<>(defaultResult);
    }

    Result getResult(final int position) {
        return defaultResult.get(position);
    }

    List<Result> getResults() {
        return new ArrayList<>(defaultResult);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DefaultResults that = (DefaultResults) o;
        return Objects.equals(defaultResult, that.defaultResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultResult);
    }
}
