package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = new ArrayList<>();
        IntStream.range(0, results.size())
                .forEach(i -> this.results.add(new Result(results.get(i), i)));
    }

    public String getNameByPosition(Position position) {
        return results.stream()
                .filter(result -> result.isMappedPosition(position))
                .findFirst()
                .map(Result::getResult)
                .get();
    }
}
