package laddergame.domain;

import laddergame.domain.move.Trace;
import laddergame.domain.name.Name;

import java.util.Map;

public class Result {
    private Map<Name, Trace> result;

    public Result(final Map<Name, Trace> result) {
        this.result = result;
    }

    public Map<Name, Trace> getResult() {
        return result;
    }
}
