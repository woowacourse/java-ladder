import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int height;
    private final List<LadderRow> ladderRows;

    public Ladder(int height, List<LadderRow> ladderRows) {
        validateHeightIsPositive(height);
        this.ladderRows = new ArrayList<>(ladderRows);
        this.height = height;
    }
    public void makeLine() {
        for (int i = 0; i < height; i++) {
            makeOneLines(ladderRows.get(i));
        }
    }

    private void makeOneLines(LadderRow ladderRow) {
        while (ladderRow.size() < ladderRow.getMaxSize()) {
            ladderRow.cross(new Random().nextBoolean());
        }
    }

    private void validateHeightIsPositive(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("최대 사다리의 높이는 양수가 되어야 합니다");
        }
    }

    public int height() {
        return height;
    }

    public List<LadderRow> getLines() {
        return ladderRows;
    }
}
