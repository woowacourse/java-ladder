package laddergame.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    public static final String DELIMITER = ",";
    private final List<Result> results;

    public Results(final String resultNames, final int participantCount) {
        List<Result> results = makeResults(resultNames);
        validateResultsSize(results, participantCount);
        this.results = results;
    }

    private List<Result> makeResults(final String resultNames) {
        return Arrays.stream(resultNames.split(DELIMITER))
                .map(Result::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateResultsSize(final List<Result> results, final int participantCount) {
        if (results.size() != participantCount) {
            throw new IllegalArgumentException("[ERROR] 실행 결과는 참여자 수와 같게 입력해야 합니다.");
        }
    }
}
