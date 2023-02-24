package laddergame.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    private final RowGenerator rowGenerator;

    public LadderGenerator(RowGenerator rowGenerator) {
        this.rowGenerator = rowGenerator;
    }

    public Ladder generate(LadderWidth width, LadderHeight height) {
        List<Row> rows = new ArrayList<>();
        int ladderWidth = width.getLadderWidth();
        int ladderHeight = height.getLadderHeight();

        while (ladderHeight-- > 0) {
            Row nextRow = rowGenerator.generate(ladderWidth);
            rows.add(nextRow);
        }

        return new Ladder(rows);
    }
}
