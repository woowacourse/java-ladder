package ladder.domain;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public PlayerPosition moveFrom(PlayerPosition initialPosition) {
        return rows.stream()
                   .reduce(initialPosition,
                           (from, row) -> row.movePlayer(from),
                           (dummy1, dummy2) -> dummy1);
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<List<Foothold>> getFootholdsMap() {
        return rows.stream()
                   .map(Row::getFootholds)
                   .collect(toUnmodifiableList());
    }

    public Map<String, String> runGame(Players players, List<String> prizes) {
        return null;
    }
}
