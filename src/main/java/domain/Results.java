package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    private final List<String> results;
    private final Map<Participant, String> participantsResult;

    public Results(String results, int participantsCount) {
        validateResultsLength(results, participantsCount);
        this.results = List.of(results.split(","));
        this.participantsResult = new HashMap<>();
    }

    private void validateResultsLength(String results, int participantsCount) {
        if (results.split(",").length != participantsCount) {
            throw new IllegalArgumentException("실행 결과의 수는 참가자 수와 동일해야 합니다.");
        }
    }

    public void recordParticipantsResult(Participant participant, int position) {
        participantsResult.put(participant, results.get(position));
    }

    public String getResultByParticipant(Participant participant) {
        return participantsResult.get(participant);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

    public Map<Participant, String> getParticipantsResult() {
        return Collections.unmodifiableMap(participantsResult);
    }
}
