package ladder.domain.result;

import java.util.List;

public class GameResults {
    private final List<PersonalGameResult> values;

    public GameResults(final List<PersonalGameResult> values) {
        this.values = values;
    }

    public String findPrizeByName(final String participantName) {
        return values.stream()
                .filter(result -> result.isResultOf(participantName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."))
                .getPrize();
    }
}
