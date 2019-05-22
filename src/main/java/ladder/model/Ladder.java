package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String NEW_LINE = "\n";
    private List<Line> lines;

    public Ladder(int height, int countOfPlayer) {
        if (!this.isValidHeight(height)) {
            throw new IllegalArgumentException("높이는 1 이상의 정수이어야 합니다.");
        }
        linesInit(countOfPlayer, height);
    }

    public int move(int startPosition) {
        int currentPosition = startPosition;
        for (int currentLine = 0; currentLine < this.ladderSize(); currentLine++) {
            currentPosition += this.getLine(currentLine).move(currentPosition);
        }
        return currentPosition;
    }

    public int ladderSize() {
        return this.lines.size();
    }

    Line getLine(int index) {
        return this.lines.get(index);
    }

    private void linesInit(int countOfPlayer, int height) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPlayer));
        }
    }

    private boolean isValidHeight(int height) {
        return height >= MIN_LADDER_HEIGHT;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ladderSize(); i++) {
            stringBuilder.append(lines.get(i)).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}
