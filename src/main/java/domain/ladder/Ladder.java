package domain.ladder;

import domain.player.PlayerCount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Row> rows;

    private Ladder(final List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder create(final Height height, final PlayerCount playerCount, final StepGenerator stepGenerator) {
        return new Ladder(createRows(height, playerCount, stepGenerator));
    }

    private static List<Row> createRows(final Height height, final PlayerCount playerCount, final StepGenerator stepGenerator) {
        List<Row> rows = new ArrayList<>();

        for (int buildHeight = 0; height.isBiggerThan(buildHeight); buildHeight++) {
            rows.add(Row.create(playerCount, stepGenerator));
        }
        return rows;
    }

    public int playLadder(int index) {
        for (Row row : rows) {
            index = row.playRow(index);
        }
        return index;
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

}
