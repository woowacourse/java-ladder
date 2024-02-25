package ladder.view;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
import ladder.domain.People;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final Map<String, String> resultMap;

    public Result(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public static Result of(People people, Ladder ladder, Compensation compensation) {
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < people.getNames().size(); i++) {
            resultMap.put(
                    people.getNames().get(i),
                    compensation.get(ladder.getResultOf(i))
            );
        }

        return new Result(resultMap);
    }

    public Map<String, String> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }
}
