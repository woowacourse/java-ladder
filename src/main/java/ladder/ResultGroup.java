package ladder;

import java.util.List;
import java.util.Objects;

public class ResultGroup {
    private final ParticipantGroup participantGroup;
    private final List<Result> results;

    public ResultGroup(ParticipantGroup participantGroup, List<Result> results) {
        checkResultsSize(participantGroup, results);
        this.participantGroup = participantGroup;
        this.results = results;
    }

    private void checkResultsSize(ParticipantGroup positionGroup, List<Result> results) {
        if (positionGroup.getSize() != results.size()) {
            throw new IllegalArgumentException("실행 결과 수가 참여자 수와 동일하지 않습니다.");
        }
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultGroup that = (ResultGroup) o;
        return Objects.equals(participantGroup, that.participantGroup) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantGroup, results);
    }
}