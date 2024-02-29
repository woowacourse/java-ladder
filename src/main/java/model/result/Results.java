package model.result;

import model.position.Position;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private final Map<Position, Result> results;

    public Results(List<String> results, int participantsSize) {
        validateResultSize(results, participantsSize);
        this.results = new LinkedHashMap<>();
        for (int i = 0; i < results.size(); i++) {
            this.results.put(Position.valueOf(i), new Result(results.get(i)));
        }
    }

    private void validateResultSize(List<String> results, int participantsSize){
        if(results.size() != participantsSize){
            throw new IllegalArgumentException("결과의 개수와 참가자의 수가 다릅니다.");
        }
    }

    public Result getResult(Position position) {
        return this.results.get(position);
    }

    public List<Result> getResults() {
        return results.values().stream().toList();
    }
}
