import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int height;
    private final List<Line> lines;

    public Ladder(int height, List<Line> lines) {
        validateHeightIsPositive(height);
        this.lines = new ArrayList<>(lines);
        this.height = height;
    }
    public void makeLine() {
        for (int i = 0; i < height; i++) {
            makeOneLines(lines.get(i));
        }
    }

    private void makeOneLines(Line line) {
        while (line.size() < line.getMaxSize()) {
            line.cross(new Random().nextBoolean());
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

    public List<Line> getLines() {
        return lines;
    }
}
