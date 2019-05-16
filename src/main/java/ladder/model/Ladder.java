package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String NEW_LINE = "\n";
    private final int height;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPlayer) {
        if (!this.isValidHeight(height)) {
            throw new IllegalArgumentException("높이는 1 이상의 정수이어야 합니다.");
        }
        this.height = height;
        linesInit(countOfPlayer);
    }

    private void linesInit(int countOfPlayer) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPlayer));
        }
    }

    private boolean isValidHeight(int height) {
        return height >= MIN_LADDER_HEIGHT;
    }

    public int linesSize() {
        return lines.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            stringBuilder.append(lines.get(i)).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
