package ladder.model;

import java.util.List;

public class Ladder {
    private final List<Row> ladder;

    public Ladder(final List<Row> ladder) {
        this.ladder = ladder;
    }

    Result play(Member member, DefaultResults results) {
        int position = member.getPosition();

        for (Row row : ladder) {
            position = row.move(position);
        }

        return results.getResult(position);
    }
}
