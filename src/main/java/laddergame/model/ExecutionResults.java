package laddergame.model;

import java.util.List;
import java.util.stream.Collectors;

public class ExecutionResults {
    private static final String ERROR_RESULT_PARTICIPANTS_NOT_SAME = "실행결과의 개수는 참여자 인원과 같아야 합니다.";

    private final List<ResultName> resultNames;

    public ExecutionResults(List<String> results, Participants participants) {
        validateSize(results, participants.getNumber());
        this.resultNames = convertToResultNames(results);
    }

    private static void validateSize(List<String> results, int participantsCount) {
        if (results.size() != participantsCount) {
            throw new IllegalArgumentException(ERROR_RESULT_PARTICIPANTS_NOT_SAME);
        }
    }

    private List<ResultName> convertToResultNames(List<String> results) {
        return results.stream()
            .map(ResultName::new)
            .collect(Collectors.toList());
    }
}
