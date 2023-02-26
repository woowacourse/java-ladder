package laddergame.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private static final String DELIMITER = ",";
    private static final int MINIMUM_COUNT = 1;

    private final List<Result> results;

    public Results(final String resultNames, final int participantCount) {
        List<Result> results = makeResults(resultNames);
        validateResultsSize(results, participantCount);
        validateIdenticalResults(results);
        this.results = results;
    }

    private List<Result> makeResults(final String resultNames) {
        return Arrays.stream(resultNames.split(DELIMITER))
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validateResultsSize(final List<Result> results, final int participantCount) {
        if (results.size() != participantCount) {
            throw new IllegalArgumentException(String.format("[ERROR] 실행 결과는 참여자 수와 같게 입력해야 합니다.%n참여자 수 : %d%n실행 결과 수 : %d", participantCount, results.size()));
        }
    }

    private void validateIdenticalResults(final List<Result> results) {
        int uniqueCount = (int) results.stream().distinct().count();
        if (uniqueCount == MINIMUM_COUNT) {
            throw new IllegalArgumentException("[ERROR] 실행 결과가 모두 동일하지 않아야 합니다.");
        }
    }

    public Result findResult(final int index) {
        return results.get(index);
    }

    public List<Result> getResults() {
        return results;
    }
}
