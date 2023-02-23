package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.util.IndexValidator;

public class Destination {

    private final List<Result> results;

    public Destination(List<Result> results) {
        this.results = results;
    }

    public int size() {
        return results.size();
    }

    public Result get(int index) {
        IndexValidator.validateBounds(index, results.size(), "주어진 위치가 종착지 정보의 개수보다 큽니다.");
        return results.get(index);
    }

    public List<Result> results() {
        return new ArrayList<>(results);
    }
}
