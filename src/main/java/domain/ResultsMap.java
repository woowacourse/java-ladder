package domain;

import java.util.*;
import java.util.stream.Collectors;

public class ResultsMap {
    private final Map<Person, Result> resultMap;

    public ResultsMap(Map<Person, Result> resultMap) {
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

    public Set<Map.Entry<Person, Result>> entrySet() {
        return resultMap.entrySet().stream()
                .map(m -> Map.entry(m.getKey(), m.getValue()))
                .collect(Collectors.toUnmodifiableSet());
    }

    public Map<Person, Result> getResultMap() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(resultMap));
    }
}
