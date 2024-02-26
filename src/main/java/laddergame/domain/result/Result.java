package laddergame.domain.result;

import java.util.Map;

public class Result {
    private Map<String, String> result;

    public Result(final Map<String, String> result) {
        this.result = result;
    }

    public Map<String, String> getResult() {
        return result;
    }
}
