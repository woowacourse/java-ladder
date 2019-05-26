package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
