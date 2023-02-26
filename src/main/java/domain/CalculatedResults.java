package domain;

import java.util.Map;

public class CalculatedResults {

    private final Map<Person, Result> resultMap;

    public CalculatedResults(Map<Person, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public boolean canTryAgain() {
        return resultMap.size() == 1;
    }

    public Result findSingleResult() {
        return resultMap.values()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과가 존재하지 않습니다."));
    }

    public Map<Person, Result> getResultMap() {
        return Map.copyOf(resultMap);
    }
}
