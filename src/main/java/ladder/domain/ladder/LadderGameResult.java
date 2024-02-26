package ladder.domain.ladder;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class LadderGameResult {
    private final List<String> values;

    public LadderGameResult(final List<String> values) {
        this.values = unmodifiableList(values);
    }
}
