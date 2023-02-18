package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

    private final LineCreateDecider lineCreateDecider;

    public LadderGenerator(LineCreateDecider lineCreateDecider) {
        this.lineCreateDecider = lineCreateDecider;
    }

    public Ladder generateLadder(int personCount, Height height) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(new Row(personCount, lineCreateDecider));
        }
        return new Ladder(rows);
    }

}
