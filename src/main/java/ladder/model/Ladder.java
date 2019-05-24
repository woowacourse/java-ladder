package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> ladder;

    private Ladder(final List<Row> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(List<Row> ladder) {
        return new Ladder(ladder);
    }

    public static Ladder nHeightLadder(int countOfMember, int height) {
        List<Row> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(Row.generateRandomRow(countOfMember));
        }

        return new Ladder(ladder);
    }

    Result play(Member member, DefaultResults results) {
        int position = member.getPosition();

        for (Row row : ladder) {
            position = row.move(position);
        }

        return results.getResult(position);
    }

    public List<Row> ladderStructure() {
        return new ArrayList<>(ladder);
    }
}
