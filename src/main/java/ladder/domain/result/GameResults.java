package ladder.domain.result;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class GameResults {
    private final List<PersonalGameResult> values;

    public GameResults(final List<PersonalGameResult> values) {
        this.values = unmodifiableList(values);
    }

    public PersonalGameResult findByName(final String participantName) {
        return values.stream()
                .filter(result -> result.isResultOf(participantName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));
    }

    public List<PersonalGameResult> getValues() {
        return values;
    }
}
