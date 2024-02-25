package domain;

import java.util.Collections;
import java.util.List;

public class Results {

    private final List<String> results;

    public Results(String results, int participantsCount) {
        validateResultsLength(results, participantsCount);
        this.results = List.of(results.split(","));
    }

    private void validateResultsLength(String results, int participantsCount) {
        if (results.split(",").length != participantsCount) {
            throw new IllegalArgumentException("실행 결과의 수는 참가자 수와 동일해야 합니다.");
        }
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
