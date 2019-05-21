package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(final List<Line> ladder) {
        this.ladder = ladder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder) {
            sb.append(line.makeLine());
        }
        return sb.toString();
    }

    int move(int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }
        return index;
    }
}
