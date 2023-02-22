package domain;

import java.util.ArrayList;
import java.util.List;

public class LinesGame {
    private final List<Integer> gameResults;

    public LinesGame(List<Line> lines) {
        gameResults = new ArrayList<>();
        startGame(lines);
    }

    private void startGame(List<Line> lines) {
        for (int i = 0; i < calculatePersonCount(lines); i++) {
            gameResults.add(calculateResultIndex(lines, i));
        }
    }

    private int calculatePersonCount(List<Line> lines) {
        return lines.get(0).getLineSize() + 1;
    }

    private int calculateResultIndex(List<Line> lines, int index) {
        for (Line line : lines) {
            index += calculateWeight(index, line);
        }
        return index;
    }

    private int calculateWeight(int index, Line line) {
        if (isAbleForward(index, line)) {
            return 1;
        }
        if (isAbleBackward(index, line)) {
            return -1;
        }
        return 0;
    }

    private boolean isAbleForward(int index, Line line) {
        return index < line.getLineSize() && line.getLine().get(index);
    }

    private boolean isAbleBackward(int index, Line line) {
        return index > 0 && line.getLine().get(index - 1);
    }

    public List<Integer> getResult() {
        return gameResults;
    }

    public int getResult(int index) {
        return gameResults.get(index);
    }
}
