package domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ResultsMap {
    private final Map<Person, Result> resultMap;

    public ResultsMap(Map<Person, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public boolean canTryAgain() {
        return resultMap.size() == 1;
    }

    public Result getSingleResult() {
        return resultMap.values()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("결과가 존재하지 않습니다."));
    }

    public Set<Map.Entry<Person, Result>> entrySet() {
        return Collections.unmodifiableSet(resultMap.entrySet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultsMap that = (ResultsMap) o;
        return Objects.equals(resultMap, that.resultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultMap);
    }
}
