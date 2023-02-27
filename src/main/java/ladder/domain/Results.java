package ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(String[] inputResults, int playerCount) {
        validateCount(inputResults.length, playerCount);
        this.results = create(inputResults);
    }

    private List<Result> create(String[] inputResults) {
        return Arrays.stream(inputResults)
                .map(Result::new)
                .collect(toList());
    }

    private void validateCount(int resultCount, int playerCount) {
        if (resultCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 입력 결과의 수가 인원 수와 같아야 합니다.");
        }
    }

    public String findResult(Ladder ladder, int startPosition) {
        int lastPosition = ladder.moveToResult(startPosition);
        return results.get(lastPosition).getResult();
    }

    public List<String> findAllResult(Ladder ladder) {
        return IntStream.range(0, ladder.getLadderWidth())
                .mapToObj(position -> findResult(ladder, position))
                .collect(toList());
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
