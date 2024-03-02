package model.result;

import model.position.Position;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Results {
    protected static final String NOT_ALLOWED_RESULTS_SIZE = "입력된 결과의 개수가 참가자의 수보다 많거나 적어, 한명의 참가자에게 하나의 결과가 매칭될 수 없습니다." + System.lineSeparator() + "참가자의 수와 동일하게 결과를 입력해야 합니다.";
    private final Map<Position, Result> results;

    public Results(List<String> results, int participantsSize) {
        validateResultSize(results, participantsSize);
        this.results = new LinkedHashMap<>();
        for (int i = 0; i < results.size(); i++) {
            this.results.put(Position.valueOf(i), new Result(results.get(i)));
        }
    }

    private void validateResultSize(List<String> results, int participantsSize) {
        if (results.size() != participantsSize) {
            throw new IllegalArgumentException(NOT_ALLOWED_RESULTS_SIZE);
        }
    }

    public Result getResult(Position position) {
        return this.results.get(position);
    }

    public List<Result> getResults() {
        return new ArrayList<>(results.values());
    }
}
