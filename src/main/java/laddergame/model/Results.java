package laddergame.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public Result findResultOfPerson(String name) {
        Optional<Result> findResult = results.stream()
                .filter(result -> Objects.equals(result.getPerson().getName(), name))
                .findAny();
        if (findResult.isPresent()) {
            return findResult.get();
        }
        throw new IllegalArgumentException("결과를 확인하고 싶은 참여자의 이름을 다시 확인해주세요.");
    }
}
