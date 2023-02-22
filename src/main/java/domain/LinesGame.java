package domain;

import java.util.ArrayList;
import java.util.List;

public class LinesGame {
    private final List<Integer> gameResults;
    private final Lines lines;

    public LinesGame(Lines lines) {
        gameResults = new ArrayList<>();
        this.lines = lines;
        startGame();
    }

    private void startGame() {
        for (int i = 0; i < calculatePersonCount(); i++) {
            gameResults.add(calculateResultIndex(i));
        }
    }

    private int calculatePersonCount() {
        return lines.getLines().get(0).getLineSize() + 1;
    }

    private int calculateResultIndex(int index) {
        for (Line line : lines.getLines()) {
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

    public int getResult(int index) {
        return gameResults.get(index);
    }
}
