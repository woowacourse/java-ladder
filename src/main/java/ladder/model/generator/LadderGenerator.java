package ladder.model.generator;

import ladder.model.Ladder;
import ladder.model.Row;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generateLadder(int countOfMember, int height) {
        List<Row> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(RowGenerator.generateRow(countOfMember));
        }

        return Ladder.of(ladder);
    }
}
