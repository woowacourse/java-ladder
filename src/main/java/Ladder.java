import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 100;
    private final List<RowLine> rowLines = new ArrayList<>();

    public Ladder(int height, int peopleNumber) {
        validateLadderHeight(height);

        LineGenerator lineGenerator = new RandomLineGenerator();
        for (int i = 0; i < height; i++) {
            this.rowLines.add(new RowLine(peopleNumber, lineGenerator));
        }
    }

    public List<RowLine> getRowLines() {
        return Collections.unmodifiableList(rowLines);
    }

    private static void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT || height > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 100이하여야 합니다");
        }
    }
}
