package ladder.domain;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {
    private final List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
